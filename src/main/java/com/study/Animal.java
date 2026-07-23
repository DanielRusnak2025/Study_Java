package com.study;

import java.util.Objects;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import static com.study.HealthStatus.HEALTHY;

public abstract class Animal {
    private String name;
    private final LocalDate birth;
    private double weight;
    private final UUID id;
    private HealthStatus animalStatus;

    Animal(String name, LocalDate birth, double weight) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }
        if (birth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата рождения не может быть в будущем");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес не может быть меньше нуля, и обязан являться числовым значением");
        }

        this.name = name;
        this.weight = weight;
        this.birth = birth;
        this.id = UUID.randomUUID();
        this.animalStatus = HEALTHY;
    }

    public int age() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public void describe(boolean verbose) {
        if (verbose) {
            System.out.println(String.format("  ─── Карточка животного ───\n" +
                    "   Имя:     %s\n" +
                    "   Возраст: %s \n" +
                    "   Состояние здоровья: %s г.\n" +
                    "   Вес:     %.2f кг", this.name, this.birth,this.animalStatus.getDescription(), this.weight));
        } else {
            System.out.println(String.format("  ─── Карточка животного ───\n" +
                    "   Имя:     %s\n", this.name));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес не может быть меньше нуля, и обязан являться числовым значением");
        }
        this.weight = weight;
    }

    public void setAnimalStatus(HealthStatus s){
        this.animalStatus = s;
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

    public HealthStatus getAnimalStatus(){
        return this.animalStatus;
    }

    public abstract String makeSound();

    @Override
    public String toString() {
        return "name=" + name + ", birth=" + birth + ", weight=" + weight + ", id=" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public UUID getId(){
        return this.id;
    }

    public AnimalCard toCard(){
        return new AnimalCard(getId(),getName(),getAnimalStatus());
    }


}
