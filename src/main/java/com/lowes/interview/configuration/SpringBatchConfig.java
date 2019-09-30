package com.lowes.interview.configuration;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
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
import org.springframework.core.io.FileSystemResource;

import com.lowes.interview.model.Sales;

@SuppressWarnings("hiding")
@Configuration
@EnableBatchProcessing
@Primary
public class SpringBatchConfig extends DefaultBatchConfigurer {
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<Sales> itemReader,
			ItemWriter<Sales> itemWriter) {
		Step step = stepBuilderFactory.get("File batch")
				.<Sales,Sales>chunk(100)
				.reader(itemReader)
				.writer(itemWriter)
				.build();
		return jobBuilderFactory.get("Spring batch Job")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
	}
	
	@Bean
	public FlatFileItemReader<Sales> itemReader(@Value("${file}") File resource) {
		FlatFileItemReader<Sales> reader = new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource(resource));
		reader.setLinesToSkip(1);
		reader.setName("CSV File Reader");
		reader.setLineMapper(lineMapper());
		return reader;
		
	}

	public LineMapper<Sales> lineMapper() {
		DefaultLineMapper<Sales> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] {"orderId","region","country","itemType","salesChannel",
				"priority","orderDate","shipDate","units","price","cost","totRevenue","totCost","totProfit"});
		
		BeanWrapperFieldSetMapper<Sales> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Sales.class);
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
	
}
