package ru.job4j.inheritance;

public class Aircraft implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }
}
