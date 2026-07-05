package com.study;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //Animal a1 = new Animal();
        //a1.describe(true);
        Animal a2 = new Animal("ror", LocalDate.of(1999, 9, 9), 9, "dog");
        new Animal("x", LocalDate.of(2029, 9, 9), -5, "dog");
        System.out.println(a2.age());
    }
}