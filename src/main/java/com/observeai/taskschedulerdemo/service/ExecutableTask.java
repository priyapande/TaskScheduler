package com.observeai.taskschedulerdemo.service;

import com.observeai.taskschedulerdemo.model.ExecStatus;
import com.observeai.taskschedulerdemo.model.TaskDTO;
import com.observeai.taskschedulerdemo.model.TaskType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class ExecutableTask implements Runnable {

    private TaskDTO task;
    private static final Logger logger = LoggerFactory.getLogger(ExecutableTask.class);

    private PersistTaskService persistTaskService;

    ExecutableTask(TaskDTO task, PersistTaskService persistTaskService) {
        this.task = task;
        this.persistTaskService = persistTaskService;
    }

    @Override
    public void run() {
        try {
            logger.info("Updating Execution time of task {}", task.getTaskId());
            task.setPickedUpTime(LocalDateTime.now());
            System.out.println("Executing" + task);
            persistTaskService.saveOrUpdateTask(task);
            logger.info("Now Executing {}", task.getTaskId());
            Thread.sleep(task.getExecTime()*1000);
            logger.info("Execution for task {} completed with SUCCESS", task.getTaskId());
            changeStatus();
        } catch (InterruptedException e) {
            logger.error("Execution for task {} Failed due to {}", task.getTaskId(), e.getMessage());
        }
    }

    private void changeStatus() {
        if(TaskType.A == task.getTaskType()) {
            task.setExecStatus(ExecStatus.COMPLETED);
        } else {
            task.setExecStatus(ExecStatus.ACTIVE);
        }
        persistTaskService.saveOrUpdateTask(task);
    }

    public TaskDTO getTask() {
        return task;
    }
}
