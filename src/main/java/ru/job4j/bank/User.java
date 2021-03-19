package ru.job4j.bank;

import java.util.Objects;

/**
 *  Класс User описывает модель пользователя банка
 */
public class User {
    /**
     * поле passport паспорт пользователя
     */
    private String passport;
    /**
     * поле username имя пользователя
     */
    private String username;

    /**
     *  Инизиализация объекта
     * @param passport
     * @param username
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод, который возвращает паспорт пользователя
     * @return
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод, который записывает паспорт пользователя в поле passport
     * @param passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод, который возвращает имя пользователя
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод, который записывает имя пользователя в поле username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
