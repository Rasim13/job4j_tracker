package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String department;
    private int experience;

    public Programmer (String department, int experience) {
        this.department = department;
        this.experience = experience;
    }
}
