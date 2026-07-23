package com.study;

public enum HealthStatus {
    HEALTHY("здоров"),
    SICK("болен"),
    RECOVERING("Выздоравливает");

    private final String description;

    HealthStatus(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
