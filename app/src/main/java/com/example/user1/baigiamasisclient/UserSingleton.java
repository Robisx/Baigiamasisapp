package com.example.user1.baigiamasisclient;

/**
 * Created by User1 on 2017-04-06.
 */
public class UserSingleton {
    private static UserSingleton ourInstance = new UserSingleton();

    public static UserSingleton getInstance() {
        return ourInstance;
    }

    private UserSingleton() {
    }
}
