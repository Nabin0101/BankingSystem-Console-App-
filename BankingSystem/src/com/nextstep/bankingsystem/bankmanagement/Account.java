package com.nextstep.bankingsystem.bankmanagement;

public class Account {
	private String accountNumber, name, address, accountType;
    private long phoneNumber, balance;

    public Account(String accountNumber, String name, String address, long phoneNumber, String accountType, long balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    
    public String getAccountNumber()
    {
    	return accountNumber;
    }
    
    public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
    public String toString() {
        return "Account Number: " + accountNumber +
                "\n Name: " + name +
                "\n Address: " + address +
                "\n Phone Number: " + phoneNumber +
                "\n Account Type: " + accountType +
                "\n Balance: Rs " + balance;
    }
}
