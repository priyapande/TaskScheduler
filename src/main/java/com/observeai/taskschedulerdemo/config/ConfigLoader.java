package com.observeai.taskschedulerdemo.config;

import com.observeai.taskschedulerdemo.service.ExecutableTask;
import com.observeai.taskschedulerdemo.model.TaskDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ConfigLoader {

    @Bean
    public PriorityBlockingQueue<ExecutableTask> taskPriorityQueue() {
        return new PriorityBlockingQueue<>(100, (e1, e2) -> {
            TaskDTO t1 = e1.getTask();
            TaskDTO t2 = e2.getTask();
           if(t1.getPriorityLevel().getValue().equals(t2.getPriorityLevel().getValue())) {
               int c = t1.getArrivalTime().compareTo(t2.getArrivalTime());
               if(c==0) return Integer.compare(t1.getExecTime(), t2.getExecTime());
               else return c;
           }
           return Integer.compare(t1.getPriorityLevel().getValue(), t2.getPriorityLevel().getValue());
        });
    }
}
