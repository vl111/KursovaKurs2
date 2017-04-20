package dao;

public interface AccountInterface {

	double replenishment(double sum);

	double payment(double sum);
	
	double acquisitionMonthly(double sum);
	
}
