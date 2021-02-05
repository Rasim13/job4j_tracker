package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if(value[i] == key) {
                System.out.println(rsl == i);
            }
        }
        throw new ElementNotFoundException("Element is not finded");
    }

    public static void main(String[] args) {
        try {
            String[] car = {"Mazda", "BMW","Toyota"};
            String key = "Vaz";
            indexOf(car,key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
