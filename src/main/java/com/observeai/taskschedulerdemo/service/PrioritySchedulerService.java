package com.observeai.taskschedulerdemo.service;

import com.observeai.taskschedulerdemo.model.ExecStatus;
import com.observeai.taskschedulerdemo.model.TaskDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

@Component
public class PrioritySchedulerService {

    private PriorityBlockingQueue<ExecutableTask> taskQueue;
    private PersistTaskService persistTaskService;
    private static final Logger logger = LoggerFactory.getLogger(PrioritySchedulerService.class);

    @Autowired
    PrioritySchedulerService(PriorityBlockingQueue<ExecutableTask> taskPriorityQueue, PersistTaskService persistTaskService) {
        this.taskQueue = taskPriorityQueue;
        this.persistTaskService = persistTaskService;
    }

    @Scheduled(cron="0 * * * * *")
    public void publishTaskToQueue() {
        LocalDateTime currTime = LocalDateTime.now();
        logger.info("Adding tasks to be executed at {}", currTime);
        List<TaskDTO> tasks = persistTaskService.getAllActiveTask(currTime);
        tasks.forEach(task -> {
            task.setExecStatus(ExecStatus.INACTIVE);
            persistTaskService.saveOrUpdateTask(task);
            taskQueue.add(new ExecutableTask(task));
        });
        logger.info("Queue size in publish {}", taskQueue.size());
    }
}
