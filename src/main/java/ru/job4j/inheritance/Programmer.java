package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String department;

    public Programmer(String name, String surname, String education, int birthday,
                      String occupation, int salary, String department) {
        super(name, surname, education, birthday, occupation, salary);
        this.department = department;
    }
}
