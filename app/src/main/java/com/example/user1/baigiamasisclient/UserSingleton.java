package com.example.user1.baigiamasisclient;

import com.example.user1.entities.Vartotojoid;

/**
 * Created by User1 on 2017-04-06.
 */
public class UserSingleton {
    private static UserSingleton ourInstance = new UserSingleton();
    private int id;
    private String name;
    private Vartotojoid vartotojas;

    private UserSingleton() {
    }

    public static UserSingleton getInstance() {
        return ourInstance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vartotojoid getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojoid vartotojas) {
        this.vartotojas = vartotojas;
    }
}
