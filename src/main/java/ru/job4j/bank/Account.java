package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс Account описывает модель банковского счета пользователя
 */

public class Account {
    /**
     * поле requisite реквизиты пользователя
     */
    private String requisite;
    /**
     * поле balance описывает баланс на счету пользователя
     */
    private double balance;

    /**
     * Инизиализация объекта
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод, который возвращает реквизиты пользователя
     * @return
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод, который записывает реквизиты пользователя в поле requisite
     * @param requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод, который возвращает баланс счета пользователя
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод, который записывает баланс пользователя
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
