package com.study;

import java.time.LocalDate;

public class Cat extends Animal {
    private boolean indoorOnly;

    public Cat(String name, LocalDate birth, double weight, boolean indoorOnly) {
        super(name, birth, weight);
        this.indoorOnly = indoorOnly;
    }

    @Override public String makeSound(){
        return "Мяу";
    }

    @Override
    public String toString(){
        return super.toString() + " | Is indoor : " + this.indoorOnly;
    }
}
