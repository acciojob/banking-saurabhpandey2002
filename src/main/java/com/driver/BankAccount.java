package com.driver;
import java.util.Random;
public class BankAccount {

    private String name;
    double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        int currentSum = 0;

        for (int i = 0; i < digits; i++) {
            int digit = random.nextInt(10); // Random digit between 0 and 9 (inclusive)
            currentSum += digit;
            accountNumber.append(digit);
        }

        if (currentSum != sum) {
            throw new Exception("Account Number can not be generated");
        }

        return accountNumber.toString();

    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

}