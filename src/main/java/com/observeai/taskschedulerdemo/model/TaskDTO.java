package com.observeai.taskschedulerdemo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class TaskDTO {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskId;

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
    private LocalDateTime pickedUpTime;

    @Column
    private LocalDateTime arrivalTime;

    public TaskDTO(TaskType taskType, int execTime, PriorityLevel priorityLevel, ExecStatus execStatus,
                   LocalDateTime startTime, LocalDateTime arrivalTime) {
        this.taskType = taskType;
        this.execTime = execTime;
        this.priorityLevel = priorityLevel;
        this.execStatus = execStatus;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
    }

    public TaskDTO() {
    }

    public TaskDTO(TaskDTO taskDTO) {
        this.taskId = taskDTO.taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public int getExecTime() {
        return execTime;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getPickedUpTime() {
        return pickedUpTime;
    }

    public void setPickedUpTime(LocalDateTime pickedUpTime) {
        this.pickedUpTime = pickedUpTime;
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
                ", pickedUpTime=" + pickedUpTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
