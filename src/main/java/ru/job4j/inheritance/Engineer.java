package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String occupation;
    private int salary;

    public Engineer (String occupation, int salary){
        super();
        this.occupation = occupation;
        this.salary = salary;
    }

}
