package com.observeai.taskschedulerdemo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class TaskDTO {

    @Id
    @Column
    private String taskId;

    @Column
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Column
    private int execTime;

    @Column
    @Enumerated(EnumType.STRING)
    private PriorityLevel priorityLevel;

    @Column
    @Enumerated(EnumType.STRING)
    private ExecStatus execStatus;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime completedTime;

    @Column
    private LocalDateTime arrivalTime;

    public TaskDTO(String taskId, TaskType taskType, int execTime, PriorityLevel priorityLevel, ExecStatus execStatus,
                   LocalDateTime startTime, LocalDateTime arrivalTime) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.execTime = execTime;
        this.priorityLevel = priorityLevel;
        this.execStatus = execStatus;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public int getExecTime() {
        return execTime;
    }

    public void setExecTime(int execTime) {
        this.execTime = execTime;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(LocalDateTime completedTime) {
        this.completedTime = completedTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public ExecStatus getExecStatus() {
        return execStatus;
    }

    public void setExecStatus(ExecStatus execStatus) {
        this.execStatus = execStatus;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId='" + taskId + '\'' +
                ", taskType=" + taskType +
                ", execTime=" + execTime +
                ", priorityLevel=" + priorityLevel +
                ", execStatus=" + execStatus +
                ", startTime=" + startTime +
                ", completedTime=" + completedTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
