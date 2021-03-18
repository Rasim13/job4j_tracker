package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User newUser = findByPassport(passport);
        users.putIfAbsent(newUser, (List<Account>) account);
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (!key.getPassport().equals(passport)) {
                users.get(passport);
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}
