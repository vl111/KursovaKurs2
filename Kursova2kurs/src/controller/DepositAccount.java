package controller;

import dao.AccountInterface;

public class DepositAccount implements AccountInterface {

	@Override
	public double replenishment(double sum) {
		return sum * 0.985;
	}

	@Override
	public double payment(double sum) {
		return sum * 1.05;
	}

	@Override
	public double acquisitionMonthly(double sum) {
		return sum * 1.04;
	}
	
	

}
