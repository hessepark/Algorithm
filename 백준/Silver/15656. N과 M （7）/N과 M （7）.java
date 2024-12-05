import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int n, m;
	static int arr[];
	static int output[];
	static boolean check[];
	static StringBuilder sb = new StringBuilder();

	public static void perm(int depth) {

		if (depth == m) {

			for (int i = 0; i < output.length; i++) {
				sb.append(output[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {

			output[depth] = arr[i];
			perm(depth + 1);

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[n];
		output = new int[m];
		check = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0);

		System.out.print(sb);

	}

}