package com.blinov.chapter11.bank;

/**
 * Created by mosdenvik on 04.10.2015.
 */
public class Client {
    private String name;
    private Account account;

    public Client(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public void withdrawMoney(Account account, int amount) {
        System.out.println("Client " + getName() + " withdraws money: " + amount);
        System.out.println("Accoun before transaction: " + account);
        if (account.getBalance() < amount) {
            System.err.println("No enough money at:" + account.toString());
        }
        account.withdrawFromClientAccount(amount);
        System.out.println("Accoun after transaction: " + account);
        Cashier.outcomingFromCashbox(amount);
    }

    public void depositMoney(Account account, int amount) {
        System.out.println("Client " + getName() + " deposits money: " + amount);
        System.out.println("Accoun before transaction: " + account);
        account.depositToClientAccount(amount);
        Cashier.incomingToCashbox(amount);
        System.out.println("Accoun after transaction: " + account);
    }

    public void transferMoney(int amount) {
        System.out.println("Client " + getName() + " transfers money: " + amount);
        Cashier.incomingToCashbox(amount);
    }

    public void payMoney(int amount) {
        System.out.println("Client " + getName() + " makes payment: " + amount);
        Cashier.incomingToCashbox(amount);
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}
