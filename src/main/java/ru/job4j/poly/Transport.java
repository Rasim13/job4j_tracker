package ru.job4j.poly;

public interface Transport {
    String go();

    int passenger(int count);

    int fill(int count, int price);
}
