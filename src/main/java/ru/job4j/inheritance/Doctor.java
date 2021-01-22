package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String country;
    private String school;

    public Doctor (String country, String school){
        this.country = country;
        this.school = school;
    }

    public Doctor() {
    }
}
