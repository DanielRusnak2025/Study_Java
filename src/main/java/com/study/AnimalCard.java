package com.study;

import java.util.UUID;

public record AnimalCard(UUID id, String name, HealthStatus status) {

    public AnimalCard{
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Имя не может быть null");
        }
    }
}
