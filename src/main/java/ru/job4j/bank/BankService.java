package ru.job4j.bank;

import java.util.*;

/**
 * Класс BankService описывает сервис банка
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод addUser добавляет нового пользователя
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод addAccount добавляет новый счет к пользователю
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User usr = findByPassport(passport);
        if (usr != null && !users.get(usr).contains(account)) {
            users.get(usr).add(account);
        }
    }

    /**
     * Метод findByPassport ищет пользователя по паспорту
     * @param passport
     * @return возвращает пользователя из коллекции или null если его нет в нашей коллекции
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод findByRequisite ищет пользователя по реквизитам
     * @param passport
     * @param requisite
     * @return возращает счет пользователя из коллекции или null если нет счета
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User usr = findByPassport(passport);
        if (usr != null) {
            for (Account account : users.get(usr)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод для перечисления денег с одного счета на другой
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return возвращает false если счет не найден или не хватает денег на счете, иначе true
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {

            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
