package com.observeai.taskschedulerdemo.model;

public enum PriorityLevel {
    HIGH("HIGH", 1),MEDIUM("MEDIUM", 2),LOW("LOW",3);
    private final String key;
    private final Integer value;

    PriorityLevel(String key, int value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
}
