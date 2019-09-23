package com.lowes.interview.service;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
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

@RestController
@RequestMapping("/rest/trigger")
public class JobService {
	@Autowired
	public JobLauncher jobLauncher;
	
	@Autowired
	public Job job;
	
	@GetMapping("test")
	public String testMethod() {
		return "abcd";
	}
	
	@GetMapping("job")
	public BatchStatus trigger() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		
		while(execution.isRunning()) {
			System.out.println("Batch is Running");
		}
		System.out.println("Batch Execution complete!!!");
		return execution.getStatus();
		
	}
	
	
}
