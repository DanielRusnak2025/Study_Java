package com.study;

import java.util.Scanner;


public class Animal {
    private String name;
    private int age;
    private double weight;
    private String type;

    Animal() {
        Scanner scanner = new Scanner(System.in);
        this.name = this.readName(scanner);
        this.weight = this.readWeight(scanner);
        this.type = this.readType(scanner);
        this.age = this.readAge(scanner);
    }

    Animal(String name, int age, double weight, String type){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.type = type;
    }

    private String readName(Scanner scanner){
        System.out.println("Имя животного : ");
        return scanner.next();
    }

    private int readAge(Scanner scanner){
        System.out.println("Возраст животного : ");
        int age = scanner.nextInt();
        while(age <= 0){
            System.out.println("Введите корректный Возраст животного (больше 0): ");
            age = scanner.nextInt();
        }
        return age;
    }

    private double readWeight(Scanner scanner){
        System.out.println("Вес животного : ");
        double weight = scanner.nextDouble();
        while (weight <= 0) {
            System.out.println("Введите корректный вес животного (больше 0): ");
            weight = scanner.nextDouble();
        }
        return weight;
    }

    private String readType(Scanner scanner){
        System.out.println("Тип животного : ");
        return scanner.next();
    }

    public String makeSound() {
        return switch (this.type) {
            case "dog" -> "Гав";
            case "cat" -> "Мяу";
            default -> "Неизвестный звук";
        };
    }

    public void describe(boolean verbose) {
        if(verbose){
        System.out.println(String.format("  ─── Карточка животного ───\n" +
                "   Имя:     %s\n" +
                "   Тип:     %s\n" +
                "   Возраст: %d г.\n" +
                "   Вес:     %.2f кг", this.name, this.type + " " + this.makeSound(), this.age, this.weight));}
        else{
            System.out.println(String.format("  ─── Карточка животного ───\n" +
                    "   Имя:     %s\n" +
                    "   Тип:     %s\n", this.name, this.type + " " + this.makeSound()));
        }
    }
}
