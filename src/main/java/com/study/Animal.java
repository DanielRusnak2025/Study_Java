package com.study;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;


public class Animal {
    private String name;
    private final LocalDate birth;
    private double weight;
    private final String type;

    Animal(String name, LocalDate birth, double weight, String type) {
        if(name == null){
            throw new IllegalArgumentException("Имя не может быть null");
        }
        if(birth.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Дата рождения не может быть в будущем");
        }
        if(weight <= 0){
            throw new IllegalArgumentException("Вес не может быть меньше нуля, и обязан являться числовым значением");
        }

        this.name = name;
        this.weight = weight;
        this.type = type;
        this.birth = birth;
    }

    /*private String readName(Scanner scanner) {
        try {
            System.out.println("Имя животного : ");
            String name = scanner.next();
            if (name == null) {
                System.out.println("Имя животного не null");
                this.readName(scanner);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
            this.readName(scanner);
        }
        return name;
    }

    private LocalDate readDateBirth(Scanner scanner) {
        LocalDate date = LocalDate.of(1, 1, 1);
        try {
            System.out.println("Год рождения животного : ");
            int year = scanner.nextInt();
            System.out.println("Месяц рождения животного : ");
            int month = scanner.nextInt();
            System.out.println("День рождения животного : ");
            int day = scanner.nextInt();

            date = LocalDate.of(year, month, day);

            if (date.isAfter(LocalDate.now())) {
                System.out.println("Некорректная дата (Дата рождения в будущем). Попробуйте снова. ");
                this.readDateBirth(scanner);
            }
            return date;
        } catch (DateTimeException | IllegalArgumentException e) {
            System.out.println("Некорректная дата. Попробуйте снова.");
            this.readDateBirth(scanner);
        }
        return date;
    }

    private double readWeight(Scanner scanner) {
        try {
            System.out.println("Введите корректный вес животного (цифровое значение больше 0): ");
            double weight = scanner.nextDouble();
            while (weight <= (double) 0) {
                System.out.println("Введите корректный вес животного (цифровое значение больше 0): ");
                weight = scanner.nextDouble();
            }
            return weight;
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("ОШИБКА - НЕВЕРНОЕ ЗНАЧЕНИЕ IllegalArgumentException | InputMismatchException");
            scanner.nextLine();
            this.readWeight(scanner);
        }
        return 0;
    }

    private String readType(Scanner scanner) {
        System.out.println("Тип животного : ");
        return scanner.next();
    }*/

    public String makeSound() {
        return switch (this.type) {
            case "dog" -> "Гав";
            case "cat" -> "Мяу";
            default -> "Неизвестный звук";
        };
    }

    public int age() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public void describe(boolean verbose) {
        if (verbose) {
            System.out.println(String.format("  ─── Карточка животного ───\n" +
                    "   Имя:     %s\n" +
                    "   Тип:     %s\n" +
                    "   Возраст: %s г.\n" +
                    "   Вес:     %.2f кг", this.name, this.type + " " + this.makeSound(), this.birth, this.weight));
        } else {
            System.out.println(String.format("  ─── Карточка животного ───\n" +
                    "   Имя:     %s\n" +
                    "   Тип:     %s\n", this.name, this.type + " " + this.makeSound()));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        if(weight <= 0){
            throw new IllegalArgumentException("Вес не может быть меньше нуля, и обязан являться числовым значением");
        }
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return this.birth;
    }

    public String getType(){
        return this.type;
    }

}
