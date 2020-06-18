package com.observeai.taskschedulerdemo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class TaskDataReceiver {
    private ExecStatus taskStatus;
    private Integer taskId;

    public ExecStatus getTaskStatus() {
        return taskStatus;
    }

    public Integer getTaskId() {
        return taskId;
    }
}
