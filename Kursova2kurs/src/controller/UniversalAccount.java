package controller;

import dao.AccountInterface;

public class UniversalAccount implements AccountInterface {

	@Override
	public double replenishment(double sum) {
		return sum;
	}

	@Override
	public double payment(double sum) {
		return sum * 1.005;
	}

	@Override
	public double acquisitionMonthly(double sum) {
		return sum * 1.014;
	}

}
