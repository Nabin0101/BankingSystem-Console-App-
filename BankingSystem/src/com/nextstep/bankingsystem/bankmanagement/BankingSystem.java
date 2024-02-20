package com.nextstep.bankingsystem.bankmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
 
    private static int lastAccountNumber = 1000;
    private static ArrayList<Account> accounts = new ArrayList<>();
    
    

    static Scanner scInt = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);
    static Scanner scLong = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" **********   Welcome to Banking System!!   ***********");
        userChoice();
    }

    public static void openAccount() {
    	System.out.println("Enter number of user you want to open account:");
    	int number= scInt.nextInt();
    	for(int i=0;i<number;i++) {
        System.out.println("Enter the details of the user");
        System.out.println("Enter name:");
        String name = scString.nextLine();
        System.out.println("Enter address:");
        String  address = scString.nextLine();
        System.out.println("Enter contact number:");
        Long phoneNumber = scLong.nextLong();
        System.out.println("Enter account type");
        String accountType = scString.nextLine();
        System.out.println("Enter an amount you want to deposit (Rs 100 Mandatory):");
        Long balance = scLong.nextLong();
        accounts.add(new Account(generateAccountNumber(), name, address, phoneNumber, accountType, balance));
    	}
        userChoice();
    }

    public static void showDetails() {
    	if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("Account Details:");
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
        userChoice();
    }

    public static void depositToAccount() {
    	System.out.println("Enter the account number to deposit:");
        String accountNumberToDeposit = scString.nextLine();
        boolean found = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumberToDeposit)) {
                System.out.println("Enter the amount you want to deposit:");
                long amount = scLong.nextLong();
                long currentBalance = account.getBalance();
                account.setBalance(currentBalance+amount);
                System.out.println("Deposit successful. Updated balance: Rs " + account.getBalance());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account with number " + accountNumberToDeposit + " not found.");
        }
        userChoice();
    }

    public static void withdrawFromAccount() {
    	 System.out.println("Enter the account number to withdraw:");
    	    String accountNumberToWithdraw = scString.nextLine();
    	    boolean found = false;
    	    for (Account account : accounts) {
    	        if (account.getAccountNumber().equals(accountNumberToWithdraw)) {
    	            System.out.println("Enter the amount you want to withdraw:");
    	            long amount = scLong.nextLong();
    	            long currentBalance = account.getBalance();
    	            if (currentBalance >= amount) {
    	                account.setBalance(currentBalance -amount);
    	                System.out.println("Withdrawal successful. Updated balance: Rs " + account.getBalance());
    	            } else {
    	                System.out.println("Insufficient balance.");
    	            }
    	            found = true;
    	            break;
    	        }
    	    }
    	    if (!found) {
    	        System.out.println("Account with number " + accountNumberToWithdraw + " not found.");
    	    }
    	    userChoice();
    }

    public static void exit() {
    	System.out.println("Do you really want to exit(Y/N)?");
        String answer = scString.next();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Exiting the banking system. Thank you for using our services!");
            System.exit(0); // Exit the program
        } else if (answer.equalsIgnoreCase("N")) {
            userChoice(); // Show the menu again
        } else {
            System.out.println("Invalid choice. Please enter Y or N.");
            exit(); // Ask again until valid input is provided
        }
    }

    public static String generateAccountNumber() {
        return "ACC" + lastAccountNumber++;
    }
    
    public static void displayDetailsByName() {
        System.out.println("Enter the name to display details:");
        String nameToSearch = scString.nextLine();
        boolean found = false;
        for (Account account : accounts) {
            if (account.getName().equalsIgnoreCase(nameToSearch)) {
                System.out.println("Account Details:");
                System.out.println(account);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account with name " + nameToSearch + " not found.");
        }
        userChoice();
        
    }
    
    public static void userChoice()
    {
    	// Asking User
        System.out.println(" 1. Open Account \n 2. Display Accoint Details\n 3. Deposit Amount \n 4. Withdraw Amount \n 5. Details of user by Name \n 6. Exit");
        int choice = scInt.nextInt();
        switch (choice) {
            case 1: {
                openAccount();
                break;
            }
            case 2: {
                showDetails();
                break;
            }
            case 3: {
                depositToAccount();
                break;
            }
            case 4: {
                withdrawFromAccount();
                break;
            }
            case 5: {
            	displayDetailsByName();
                break;
            }
            case 6:
            {
            	exit();
            	break;
            }
        }
    }
}
