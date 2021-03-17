package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String country;
    private String school;

    public Doctor(String country, String school, String name,
                   String surname, String education, int birthday) {
        super(name, surname, education, birthday);
        this.country = country;
        this.school = school;
    }

}
