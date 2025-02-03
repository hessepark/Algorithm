import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static int arr[];
	public static int ans[];
	public static boolean isVisited[];
	public static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		isVisited = new boolean[n];
		sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0, 0);

		System.out.println(sb);

	}

	public static void perm(int depth, int pos) {

		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = pos; i < arr.length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				ans[depth] = arr[i];
				perm(depth + 1, i + 1);
				isVisited[i] = false;
			}
		}

	}
}