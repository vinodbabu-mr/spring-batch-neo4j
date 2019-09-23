package com.lowes.interview.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowes.interview.model.Salesdata;
import com.lowes.interview.repository.SalesRepository;

@Component
public class DBWriter implements ItemWriter<Salesdata> {
	
	@Autowired
	private SalesRepository salesRepository;

	@Override
	public void write(List<? extends Salesdata> items) throws Exception {
		salesRepository.save(items);
		
	}

	
}
