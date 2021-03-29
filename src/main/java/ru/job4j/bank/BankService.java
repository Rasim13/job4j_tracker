package ru.job4j.bank;

import java.util.*;
import java.util.Optional;

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
        Optional <User> findUser = findByPassport(passport);
        if (findUser.isPresent()) {
            List <Account> accounts = users.get(findUser.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод findByPassport ищет пользователя по паспорту
     * @param passport
     * @return возвращает пользователя из коллекции или null если его нет в нашей коллекции
     */
        public Optional<User> findByPassport(String passport) {
            return users.keySet().stream()
                    .filter(n -> n.getPassport().equals(passport))
                    .findFirst();
    }

    /**
     * Метод findByRequisite ищет пользователя по реквизитам
     * @param passport
     * @param requisite
     * @return возращает счет пользователя из коллекции или null если нет счета
     */
        public Optional<Account> findByRequisite(String passport, String requisite) {
            Optional<User> findUser = findByPassport(passport);
            if (findUser.isPresent()) {
                return users.get(findUser.get()).stream()
                        .filter(n -> n.getRequisite().equals(requisite))
                        .findFirst();
            }
            return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
            if (srcAccount.isPresent() && destAccount.isPresent()
                    && srcAccount.get().getBalance() >= amount) {
                    srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                    destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                    rsl = true;
            }
            return rsl;
    }
}

