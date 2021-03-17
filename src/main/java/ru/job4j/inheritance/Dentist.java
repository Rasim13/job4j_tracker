package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String head;

    public Dentist(String country, String school, String name, String surname,
                   String education, int birthday, String head) {
        super(country, school, name, surname, education, birthday);
        this.head = head;
    }
}
