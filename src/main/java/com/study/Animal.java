package com.study;

import java.util.Scanner;

public class Animal {
    private String name;
    private int age;
    private double weight;
    private String type;

    Scanner scanner = new Scanner(System.in);
    Animal() {
        System.out.println("Имя животного : ");
        this.name = scanner.next();

        System.out.println("Возраст животного : ");
        this.age = scanner.nextInt();
        while (this.age <= 0) {
            System.out.println("Введите корректный Возраст животного (больше 0): ");
            this.age = scanner.nextInt();
        }

        System.out.println("Вес животного : ");
        this.weight = scanner.nextDouble();
        while (this.weight <= 0) {
            System.out.println("Введите корректный вес животного (больше 0): ");
            this.weight = scanner.nextDouble();
        }

        System.out.println("Тип животного : ");
        this.type = scanner.next();
    }

    Animal(String name, int age, double weight, String type){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.type = type;
    }


    public String makeSound() {
        return switch (this.type) {
            case "dog" -> "Гав";
            case "cat" -> "Мяу";
            default -> "Неизвестный звук";
        };
    }

    public void animalCard() {
        System.out.println(String.format("  ─── Карточка животного ───\n" +
                "   Имя:     %s\n" +
                "   Тип:     %s\n" +
                "   Возраст: %d г.\n" +
                "   Вес:     %.2f кг", this.name, this.type + " " + this.makeSound(), this.age, this.weight));
    }
}
