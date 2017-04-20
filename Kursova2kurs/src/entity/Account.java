package entity;

import dao.AccountInterface;
import enums.TypeAccount;

public abstract class Account {

	private long id;
	private double balance;
	private TypeAccount typeAccount;
	private AccountInterface ai;

	protected Account(long id, double balance, TypeAccount typeAccount, AccountInterface ai) {
		this.id = id;
		this.balance = balance;
		this.typeAccount = typeAccount;
		this.ai = ai;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountInterface getAi() {
		return ai;
	}
}
