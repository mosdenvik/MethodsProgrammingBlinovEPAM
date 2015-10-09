package com.blinov.chapter11.bank;

/**
 * Created by mosdenvik on 04.10.2015.
 */
public class Account {
    private int balance;

    public Account(int account) {
        this.balance = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public void withdrawFromClientAccount(int amount){
        balance -= amount;
    }

    public void depositToClientAccount(int amount){
        balance += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance: " + balance +
                '}';
    }
}
