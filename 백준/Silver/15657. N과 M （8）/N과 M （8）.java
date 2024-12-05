import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static int arr[];
	public static int ans[];
	public static boolean check[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		ans = new int[m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		dfs(0, 0);
		
		System.out.println(sb);

	}

	public static void dfs(int pos, int depth) {

		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = pos; i < n; i++) {
				ans[depth] = arr[i];
				dfs(i, depth + 1);
		}
	}

}
