package controller;

import entity.Account;

public class Actions {
	
	public static double replenishment(Account ac, double sum) {
		return ac.getBalance() + ac.getAi().replenishment(sum);
	}

	public static double payment(Account ac, double sum) {
		return ac.getBalance() - ac.getAi().payment(sum);
	}

	public static double acquisitionMonthly(Account ac) {
		return ac.getAi().acquisitionMonthly(ac.getBalance());
	}
}
