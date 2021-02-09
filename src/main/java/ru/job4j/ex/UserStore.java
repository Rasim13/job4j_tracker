package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if(users[i].equals(login)) {
                return users[i];
            }
        }
        throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
            int number = user.getUsername().length();
            if(number < 3) {
                throw new UserInvalidException();
            } else if (user.isValid() == false) {
                throw new UserInvalidException();
            }

        return false;
    }

    public static void main(String[] args) {
        try {
            User[] users = {new User("Petr Arsentev", true)};
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e){
            System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException e){
            System.out.println("Ползователь не найден");
        }

    }
}
