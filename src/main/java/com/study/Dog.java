package com.study;

import java.time.LocalDate;

public class Dog extends Animal {

    private String breed;

    public Dog(String name, LocalDate birth, double weight, String breed) {
        super(name, birth, weight);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Гав";
    }

    @Override
    public String toString(){
        return super.toString() + " | Breed : " + this.breed;
    }
}
