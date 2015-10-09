package com.blinov.chapter11.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mosdenvik on 04.10.2015.
 */
public class Bank {
    private String name;
    public static List<Client> clientsList = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Client> getClientsList() {
        return clientsList;
    }

    public static void setClientsList(List<Client> clientsList) {
        Bank.clientsList = clientsList;
    }

    public void addClientToList(Client client) {
        clientsList.add(client);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                '}';
    }
}



