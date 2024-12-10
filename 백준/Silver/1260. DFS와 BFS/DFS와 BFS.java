import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

	public static int n;
	public static boolean[] check;
	public static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();

		list = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		check = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			list[x].add(y);
			list[y].add(x);
		}
		
		for(int i=1;i<n+1;i++) {
			Collections.sort(list[i]);
		}

		dfs(v);
		System.out.println();

		check = new boolean[n + 1];

		bfs(v);

	}

	public static void dfs(int num) {
		check[num] = true;
		System.out.print(num + " ");
		for (int n : list[num]) {
			if (!check[n]) {
				dfs(n);
			}
		}
	}

	public static void bfs(int num) {

		ArrayDeque<Integer> q = new ArrayDeque<>();
		check[num] = true;
		q.add(num);
		while (!q.isEmpty()) {
			int n = q.poll();
			System.out.print(n+" ");
			for (int number : list[n]) {
				if (!check[number]) {
					check[number] = true;
					q.add(number);
				}
			}
		}

	}
}