package ru.job4j.oop;

public class DummyDic {

    public String engToRus(){
        return "Car";
    }

    public static void main(String[] args) {
        DummyDic nic = new DummyDic();
        String word = nic.engToRus();
        System.out.println("Неизвестное слово." + word);
    }
}
