package com.blinov.chapter11.bank;

/**
 * Created by mosdenvik on 04.10.2015.
 */
public class BankDepository {
    private static volatile int bankDeposit;


    public BankDepository(int bankDeposit) {
        this.bankDeposit = bankDeposit;
    }

    public void setBankDeposit(int bankDeposit) {
        this.bankDeposit = bankDeposit;
    }

    public int getBankDeposit() {
        return bankDeposit;
    }

    public static void withdrawFromDepository(int amount){
        bankDeposit -= amount;
    }

    public static void depositToDepository(int amount){
        bankDeposit += amount;
    }

    public void checkBankDepository(){
        System.out.println("***Current balance at the bank depository: " + bankDeposit);
    }
}
