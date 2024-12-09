import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static int ans[];
	public static ArrayList<Integer> list[];
	public static boolean isVisited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		ans = new int[n + 1];

		list = new ArrayList[n + 1];
		isVisited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

//		for (int i = 1; i < n + 1; i++) {
//			System.out.println(list[i]);
//		}

		bfs(1);

		for (int i = 2; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	public static void bfs(int depth) {
		isVisited[depth] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(depth);

		while (!q.isEmpty()) {
			int num = q.poll();
			for (int next : list[num]) {
				if (!isVisited[next]) {
					isVisited[next] = true;
					q.add(next);
					ans[next] = num;
				}
			}

		}

	}
}