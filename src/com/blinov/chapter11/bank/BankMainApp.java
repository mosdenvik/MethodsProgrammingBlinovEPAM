package com.blinov.chapter11.bank;

/**
 * Created by mosdenvik on 05.10.2015.
 */
public class BankMainApp {
    public static final int NUMBER_OF_CASHIER = 5;

    public static void main(String[] args) {
        Bank bank = new Bank("Arkada");
        BankDepository bankDepository = new BankDepository(1_000_000);
        Cashier cashier = new Cashier("Smirnova O.S.");
        cashier.setAvailableCash(150000);
        Thread cashierThread = new Thread(cashier);
        cashierThread.start();
        Client client1 = new Client("Mironov A.A.", new Account(65000));
        Client client2 = new Client("Voronov N.A.", new Account(10000));
        Client client3 = new Client("Nikitina V.D.", new Account(23500));
        Client client4 = new Client("Vinogradov B.S.", new Account(150000));
        Client client5 = new Client("Golovin M.O.", new Account(57200));
        Client client6 = new Client("Sergienko E.V.", new Account(18450));
        Client client7 = new Client("Kravchenko T.D.", new Account(7630));
        Client client8 = new Client("Sidorenko D.P.", new Account(3850));
        Client client9 = new Client("Vasiltsov A.I.", new Account(35200));
        Client client10 = new Client("Royzman G.A.", new Account(200000));

        bank.addClientToList(client1);
        bank.addClientToList(client2);
        bank.addClientToList(client3);
        bank.addClientToList(client4);
        bank.addClientToList(client5);
        bank.addClientToList(client6);
        bank.addClientToList(client7);
        bank.addClientToList(client8);
        bank.addClientToList(client9);
        bank.addClientToList(client10);

        cashier.toServeClient(client1, Operation.WITHDRAW, 60000);
        bankDepository.checkBankDepository();
        System.out.println("----------------------------");
        cashier.toServeClient(client2, Operation.TRANSFER, 200000);
        System.out.println("----------------------------");
//        cashier.toServeClient(client3, Operation.DEPOSIT, 5000);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client4, Operation.WITHDRAW, 200000);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client5, Operation.PAY, 83000);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client6, Operation.DEPOSIT, 18230);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client7, Operation.WITHDRAW, 2000);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client8, Operation.TRANSFER, 10000);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client9, Operation.WITHDRAW, 30000);
//        System.out.println("----------------------------");
//        cashier.toServeClient(client10, Operation.WITHDRAW, 200000);
//        System.out.println("----------------------------");
        System.out.println(cashierThread.isAlive());
        bankDepository.checkBankDepository();
        System.out.println(Thread.currentThread().getName());

        try {
            cashierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
