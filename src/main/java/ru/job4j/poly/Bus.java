package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String go() {
        return null;
    }

    @Override
    public int passenger(int count) {
        return 0;
    }

    @Override
    public int fill(int count, int price) {
        return count * price;
    }
}
