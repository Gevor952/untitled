package homework.online_store.storage;

import homework.online_store.model.User;
import homework.online_store.util.SerializeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserStorage {
    List<User> users = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(User user) {
        users.add(user);
        SerializeUtil.serializeUserData(users);
    }


    public User searchUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Please input password");
                String password = scanner.nextLine();
                if (password.equals(user.getPassword())) {
                    return user;
                }
                System.out.println("Wrong password");
                return null;
            }
        }
        return null;
    }

    public void print() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public User getById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void deserializeUsers() {
        this.users = SerializeUtil.deserializeUserData();
    }
}
