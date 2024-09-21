package homework.online_store.storage;

import homework.online_store.model.User;

import java.util.Scanner;

public class UserStorage {
    private User[] users = new User[100];
    private int size = 0;
    Scanner scanner = new Scanner(System.in);

    public void add(User user)
    {
        if(size == users.length)
        {
            extendStorage();
        }
        users[size++] = user;
    }

    private void extendStorage()
    {
        User[] temp = new User[users.length * 2];
        System.arraycopy(users, 0, temp, 0, users.length);
        users = temp;
    }

    public User searchUserByEmail(String email) {
        for(int i = 0; i < size; i++)
        {
            if(users[i].getEmail().equals(email))
            {
                System.out.println("Please input password");
                String password = scanner.nextLine();
                if(password.equals(users[i].getPassword()))
                {
                    return users[i];
                }
                System.out.println("Wrong password");
                return null;
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }
}
