
public class JORIK {

	static int[] ledders = { 2, -3, 5, 6, -3, 6, 2, 8, 1, 2 };

	public static int[] J(int[] led, int n1, int n2) {
		if (n1 < 0)
			n1 = 0;
		int k = led[n2];
		int max = Integer.MIN_VALUE;
		for (int i = n1; i < n2; i++) {
			if (led[n2] < led[i] + k) {
				led[n2] = k + led[i];
				max = i;
			}
		}
		System.out.print(max + "  ");
		if (n2 + 1 < led.length)
			return J(led, n2 - 4, n2 + 1);
		else
			return led;
	}

	public static void outp(int[] led) {
		System.out.println();
		for (int i = 0; i < led.length; i++) {
			System.out.println(led[i]);
		}
	}

	public static void main(String[] args) {

		outp(J(ledders, -3, 1));

	}

}
