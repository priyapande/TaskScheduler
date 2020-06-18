package com.observeai.taskschedulerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskSchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSchedulerDemoApplication.class, args);
	}

}
