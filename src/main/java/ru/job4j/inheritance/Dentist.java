package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String head;
    private String tooth;

    public Dentist(String country, String school, String name, String surname,
                   String education, int birthday, String head, String tooth) {
        super(country, school, name, surname, education, birthday);
        this.head = head;
        this.tooth = tooth;
    }
}
