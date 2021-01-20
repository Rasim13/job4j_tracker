package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book history = new Book("Rim", 2);
        Book literature = new Book("War and World", 4);
        Book physics = new Book("Mechanics", 5);
        Book chemistry = new Book("Organic", 3);
        Book book = new Book("Clean code", 8);
        Book[] numberOf = new Book[4];
        numberOf[0] = history;
        numberOf[1] = literature;
        numberOf[2] = physics;
        numberOf[3] = chemistry;
        for (int index = 0; index < numberOf.length; index++){
            Book bk = numberOf[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }
        System.out.println();
        Book tmp = numberOf[0];
        numberOf[0] = numberOf[numberOf.length - 1];
        numberOf[numberOf.length - 1] = tmp;
        for (int index = 0; index < numberOf.length; index++){
            Book bk = numberOf[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }
        System.out.println();
        for (int index = 0; index < numberOf.length; index++){
            Book bk = numberOf[index];
            System.out.println(bk.getName() + " - " + bk.getNumber());
        }


    }
}
