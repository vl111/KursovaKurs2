import java.util.Random;

public class leders {

	public static Random rand = new Random();
	public static double money = 5000;

	public static void led(int amount) {
		int chance = rand.nextInt(100) + 1;
		money = money - amount;
		if (chance <= 6) {
			money = money + (amount * 16.777);
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 16; i++) {
			led(100);
		}
		System.out.println(money);
	}

}
