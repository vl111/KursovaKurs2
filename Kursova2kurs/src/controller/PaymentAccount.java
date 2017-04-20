package controller;

import dao.AccountInterface;

public class PaymentAccount implements AccountInterface {

	@Override
	public double replenishment(double sum) {
		return sum * 0.995;
	}

	@Override
	public double payment(double sum) {
		return sum * 1.001;
	}

	@Override
	public double acquisitionMonthly(double sum) {
		return sum * 1.008;
	}

}
