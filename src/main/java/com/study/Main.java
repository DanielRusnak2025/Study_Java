package com.study;


import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
                new Dog("ree",LocalDate.of(1999,9,9),1.2,"huh"),
                new Dog("ree",LocalDate.of(2009,9,9),1.2,"huh"),
                new Cat("ree",LocalDate.of(1999,9,9),1.2,true),
                new Cat("ree",LocalDate.of(1999,9,9),1.2,false)
        );

        for(Animal animal : animals){
            System.out.println(animal.makeSound());
        }

        for(Animal animal : animals){
            System.out.println(animal.equals(animals.get(0)));
        }

    }
}