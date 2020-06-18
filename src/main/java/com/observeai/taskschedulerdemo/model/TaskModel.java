package com.observeai.taskschedulerdemo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class TaskModel {
    private TaskType taskType;
    private int execTime;
    private PriorityLevel priorityLevel;
    private int startOffset;

    public TaskType getTaskType() {
        return taskType;
    }

    public int getExecTime() {
        return execTime;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public int getStartOffset() {
        return startOffset;
    }
}
