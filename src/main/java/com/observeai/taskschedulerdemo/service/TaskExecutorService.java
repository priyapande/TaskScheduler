package com.observeai.taskschedulerdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class TaskExecutorService {
    private final PriorityBlockingQueue<ExecutableTask> taskQueue;
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorService.class);

    private ExecutorService taskExecutor;

    @Autowired
    TaskExecutorService(PriorityBlockingQueue<ExecutableTask> taskPriorityQueue) {
        this.taskQueue = taskPriorityQueue;
        taskExecutor = Executors.newFixedThreadPool(2);
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void consumeTaskFromQueue() {
        while(!taskQueue.isEmpty()) {
            try {
                taskExecutor.execute(taskQueue.take());
                logger.info("Queue size in consumer {}", taskQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
