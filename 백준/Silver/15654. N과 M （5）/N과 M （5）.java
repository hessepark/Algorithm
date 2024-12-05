import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int N, M;
	static int[] arr;
	static boolean[] check;
	static int[] output;
	static StringBuilder sb = new StringBuilder();

	public static void perm(int depth) {
		if (depth == M) { // base case
			// TODO 출력
			for (int i = 0; i < M; i++) {
				sb.append(output[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) { // recursive case
			if (!check[i]) {
				check[i] = true;
				output[depth] = arr[i];
				perm(depth + 1);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		check = new boolean[N];
		output = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0);
		System.out.println(sb);
	}
}