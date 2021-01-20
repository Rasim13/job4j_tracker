package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSurname("Zamaltdinov");
        student.setName("Rasim");
        student.setLastName("Ilgizovich");
        student.setGroup("group B");
        student.setCreated(new Date());

        System.out.println("Suranme: " + student.getSurname() + "\nName: " + student.getName() +
                "\nLastName: " + student.getLastName() + "\nGroup: " + student.getGroup() +
                "\nData of receipt: " + student.getCreated());
    }
}
