package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        Citizen newCitizen = citizens.get(citizen.getPassport());
        if (citizens.containsKey(newCitizen) == false) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }


    public Citizen get(String passport) {
        return null;
    }
}
