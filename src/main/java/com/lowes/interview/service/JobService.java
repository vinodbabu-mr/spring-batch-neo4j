package com.lowes.interview.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowes.interview.model.Sales;
import com.lowes.interview.repository.SalesRepository;

@RestController
@RequestMapping("/rest/")
public class JobService {
	@Autowired
	public JobLauncher jobLauncher;
	
	@Autowired
	SalesRepository salesRepo;
	
	@Autowired
	public Job job;
	
	@GetMapping("sales")
	public List<Sales> getSales()  {
		Iterable<Sales> Sales = new ArrayList<>();
		List<Sales> salesList = new ArrayList<>();
		salesList = salesRepo.findSalesData();
		Sales.forEach(salesList::add);
 		return salesList;
	}
	
	@GetMapping("trigger")
	public BatchStatus trigger() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
		JobExecution execution = jobLauncher.run(job, parameters);
		
		while(execution.isRunning()) {
			System.out.println("Batch is Running");
		}
		System.out.println("Batch Execution complete!!!");
		return execution.getStatus();
		
	}
	
}
