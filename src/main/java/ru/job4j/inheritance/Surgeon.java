package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String leg;
    private String hospital;

    public Surgeon (String leg, String hospital){
        this.leg = leg;
        this.hospital = hospital;
    }
}
