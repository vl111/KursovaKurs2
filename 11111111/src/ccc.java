
public class ccc {

	public static int k;
	public static int[] array = { 9, 6, 5, 3, 1, 0, 2, 6, 8, 7 };

	public static void bubble(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				k = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = k;
				//i = 0;
				bubble(arr);
			}
		}

	}

	public static void main(String[] args) {
		bubble(array);

		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + "  ");
		}
	}

}
