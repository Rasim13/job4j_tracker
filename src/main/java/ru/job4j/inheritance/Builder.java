package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String field;
    private String house;

    public Builder(String name, String surname, String education, int birthday,
                   String occupation, int salary, String field, String house) {
        super(name, surname, education, birthday, occupation, salary);
        this.field = field;
        this.house = house;
    }
}
