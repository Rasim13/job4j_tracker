package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String occupation;
    private int salary;

    public Engineer(String name, String surname, String education,
                    int birthday, String occupation, int salary) {
        super(name, surname, education, birthday);
        this.occupation = occupation;
        this.salary = salary;
    }
}
