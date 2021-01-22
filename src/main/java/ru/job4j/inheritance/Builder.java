package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String field;
    private String house;

    public Builder (String field, String house){
        this.field = field;
        this.house = house;
    }

}
