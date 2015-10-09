package com.blinov.chapter11.bank;


/**
 * Created by mosdenvik on 04.10.2015.
 */
public class Cashier implements Runnable {
    private String name;
    private BankDepository bankDepository;
    private static volatile int availableCash;
    public static final int LOW_CASHBOX_LIMIT = 100_000;
    public static final int HIGH_CASHBOX_LIMIT = 300_000;
    private boolean enoughMoney = true;


    public Cashier(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankDepository getBankDepository() {
        return bankDepository;
    }

    public int getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(int availableCash) {

        this.availableCash = availableCash;
    }

    @Override
    public void run() {
        while (true) {
            checkAvailableCash();
        }
    }

    public synchronized void toServeClient(Client client, Operation operation, int amount) {
        switch (operation) {
            case WITHDRAW:
                client.withdrawMoney(client.getAccount(), amount);
                break;
            case DEPOSIT:
                client.depositMoney(client.getAccount(), amount);
                break;
            case TRANSFER:
                client.transferMoney(amount);
                break;
            case PAY:
                client.payMoney(amount);
                break;
        }
    }

    public static void outcomingFromCashbox(int amount) {
        System.out.println("Cash in cashbox before transaction: " + availableCash);
        availableCash -= amount;
        System.out.println("Cash in cashbox after transaction: " + availableCash);
    }

    public static void incomingToCashbox(int amount) {
        System.out.println("Cash in cashbox before transaction: " + availableCash);
        availableCash += amount;
        System.out.println("Cash in cashbox after transaction: " + availableCash);
    }

    public void takeMoneyFromDepository(int amount) {
        System.out.println("---No enough money into cashbox. Try to withdraw from Bank Depository: " + amount);
        bankDepository.withdrawFromDepository(amount);
        incomingToCashbox(amount);
        System.out.println("---Now available cash is: " + availableCash);
    }

    public void sendMoneyToDepository(int amount) {
        System.out.println("---To much cash in cashbox. Try to send " + amount + " into Bank Depository");
        bankDepository.depositToDepository(amount);
        outcomingFromCashbox(amount);
        System.out.println("---Now available cash is: " + availableCash);
    }

    public void checkAvailableCash() {
        if (availableCash < LOW_CASHBOX_LIMIT) {
            takeMoneyFromDepository(50000);
        }
        if (availableCash > HIGH_CASHBOX_LIMIT) {
            sendMoneyToDepository(100000);
        }
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "availableCash: " + availableCash +
                '}';
    }
}
