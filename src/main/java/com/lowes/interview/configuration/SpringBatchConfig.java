package com.lowes.interview.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lowes.interview.model.Salesdata;

@SuppressWarnings("hiding")
@Configuration
@EnableBatchProcessing
@Primary
public class SpringBatchConfig<Salesdata> {
	
	@SuppressWarnings("unchecked")
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<Salesdata> itemReader,
			ItemWriter<Salesdata> itemWriter) {
		Step step = stepBuilderFactory.get("File batch")
				.<Salesdata,Salesdata>chunk(100)
				.reader(itemReader)
				.writer(itemWriter)
				.build();
		return jobBuilderFactory.get("Spring batch Job")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
	}
	
	@Bean
	public FlatFileItemReader<Salesdata> itemReader(@Value("${file}") Resource resource) {
		FlatFileItemReader<Salesdata> reader = new FlatFileItemReader<>();
		reader.setResource(resource);
		reader.setLinesToSkip(1);
		reader.setName("CSV File Reader");
		reader.setLineMapper(lineMapper());
		return reader;
		
	}

	public LineMapper<Salesdata> lineMapper() {
		DefaultLineMapper<Salesdata> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] {"orderId","region","country","country","salesChannel",
				"priority","orderDate","shipDate","units","price","cost","totRevenue","totCost","totProfit"});
		
		BeanWrapperFieldSetMapper<Salesdata> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		//fieldSetMapper.setTargetType(Salesdata.class);
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
	
}
