import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Lab3 {
	private static int heapSize;

	static File fileInput;
	static FileReader fr;
	static BufferedReader br;

	static File fileOut;
	static FileWriter fw;
	static BufferedWriter bw;

	public static int[] A = { 3, 4, 7, 1, 7, 2, 7, 3, 1, 9, 2 };
	public static int[] s1Rand = new int[10000];
	public static int[] s2Rand = new int[20000];
	public static int[] s3Rand = new int[30000];
	public static int[] s4Rand = new int[40000];
	public static int[] s5Rand = new int[50000];

	public static int[] s1SortB = new int[10000];
	public static int[] s2SortB = new int[20000];
	public static int[] s3SortB = new int[30000];
	public static int[] s4SortB = new int[40000];
	public static int[] s5SortB = new int[50000];

	public static int[] s1Sort = new int[10000];
	public static int[] s2Sort = new int[20000];
	public static int[] s3Sort = new int[30000];
	public static int[] s4Sort = new int[40000];
	public static int[] s5Sort = new int[50000];

	public static Random rand = new Random();

	public static void fill() {
		for (int i = 0; i < s1Rand.length; i++) {
			s1Rand[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		for (int i = 0; i < s2Rand.length; i++) {
			s2Rand[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		for (int i = 0; i < s3Rand.length; i++) {
			s3Rand[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		for (int i = 0; i < s4Rand.length; i++) {
			s4Rand[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		for (int i = 0; i < s5Rand.length; i++) {
			s5Rand[i] = rand.nextInt(Integer.MAX_VALUE);
		}

		for (int i = 0; i < s1SortB.length; i++) {
			s1SortB[i] = s1SortB.length - i;
		}
		for (int i = 0; i < s2SortB.length; i++) {
			s2SortB[i] = s2SortB.length - i;
		}
		for (int i = 0; i < s3SortB.length; i++) {
			s3SortB[i] = s3SortB.length - i;
		}
		for (int i = 0; i < s4SortB.length; i++) {
			s4SortB[i] = s4SortB.length - i;
		}
		for (int i = 0; i < s5SortB.length; i++) {
			s5SortB[i] = s5SortB.length - i;
		}

		for (int i = 0; i < s1Sort.length; i++) {
			s1Sort[i] = i;
		}
		for (int i = 0; i < s2Sort.length; i++) {
			s2Sort[i] = i;
		}
		for (int i = 0; i < s3Sort.length; i++) {
			s3Sort[i] = i;
		}
		for (int i = 0; i < s4Sort.length; i++) {
			s4Sort[i] = i;
		}
		for (int i = 0; i < s5Sort.length; i++) {
			s5Sort[i] = i;
		}

	}

	public static void execute() throws IOException {
		fileInput = new File(".\\TA1input.txt");
		if (!fileInput.exists()) {
			ifFirst();
		}
		fr = new FileReader(fileInput);
		br = new BufferedReader(fr);

		fileOut = new File(".\\TA1output.txt");
		fileOut.createNewFile();
		fw = new FileWriter(fileOut);
		bw = new BufferedWriter(fw);

		String str = br.readLine();
		while (!str.equals("*****")) {

			if (str.equals("#####")) {
				str = br.readLine();

				fill();

				long timeout = System.currentTimeMillis();

					sort(s1Rand);
					
				timeout = System.currentTimeMillis() - timeout;
				System.out.println(timeout);
				bw.write("time in millis: " + timeout);
			}
			str = br.readLine();
		}

	}

	public static void ifFirst() throws IOException {
		fileInput.createNewFile();

		fw = new FileWriter(fileInput);
		bw = new BufferedWriter(fw);

		for (int i = 0; i < 3; i++) {
			for (int i1 = 0; i1 < 5; i1++) {
				if (i == 0) {
					bw.write("s" + (i1 + 1) + "Rand");
				} else if (i == 1) {
					bw.write("s" + (i1 + 1) + "Sort");
				} else if (i == 2) {
					bw.write("s" + (i1 + 1) + "SortB");
				}
				bw.newLine();
			}
			bw.write("");
			bw.newLine();
		}
		bw.newLine();
		bw.write("#####");
		bw.newLine();
		bw.write("");
		bw.newLine();
		bw.write("*****");

		bw.close();

	}

	// =======================================================================

	public static void sort(int[] a) {
		buildHeap(a);
		while (heapSize > 1) {
			// swap(a, 0, heapSize - 1);
			heapSize--;
			swap(a, 0, heapSize);
			heapify(a, 0);
		}
	}

	private static void buildHeap(int[] a) {
		heapSize = a.length;
		for (int i = a.length / 2; i >= 0; i--) {
			heapify(a, i);
		}
	}

	private static void heapify(int[] a, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < heapSize && a[i] < a[l]) {
			largest = l;
		}
		if (r < heapSize && a[largest] < a[r]) {
			largest = r;
		}
		if (i != largest) {
			swap(a, i, largest);
			heapify(a, largest);
		}
	}

	private static int right(int i) {
		return 2 * i + 1;
	}

	private static int left(int i) {
		return 2 * i + 2;
	}

	private static void swap(int[] a, int i, int j) {
		int num = a[i];
		a[i] = a[j];
		a[j] = num;
	}

	public static void main(String[] args) throws IOException {
		execute();

		bw.close();
		fw.close();
		
		/*
		 * System.out.println(""); for (int i = 0; i < 150; i++) {
		 * System.out.print(s5Rand[i] + "  "); }
		 */

	}

}

