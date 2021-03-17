package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String leg;

    public Surgeon(String country, String school, String name, String surname,
                   String education, int birthday, String leg) {
        super(country, school, name, surname, education, birthday);
        this.leg = leg;
    }
}
