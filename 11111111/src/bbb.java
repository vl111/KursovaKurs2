
public class bbb {

	public static int[] arr = { 5, 4, -3, 4, 2, -5, 7, -8, 4, 0, 6, 8, -23, 5, 7, 1000, 0 };
	public static int[] res = new int[arr.length];

	public static int alg(int[] arr, int k, int val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] * val > 0) {
				res[k] = arr[i];
				k++;
			}
		}
		return k;
	}

	public static void main(String[] args) {
		alg(arr, alg(arr, 0, -1), 1);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
