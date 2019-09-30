package com.lowes.interview.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowes.interview.model.Sales;
import com.lowes.interview.repository.SalesRepository;

@Component
public class DBWriter implements ItemWriter<Sales> {
	
	@Autowired
	private SalesRepository salesRepository;

	@Override
	public void write(List<? extends Sales> items) throws Exception {
		salesRepository.save(items,-1);
	}
}
