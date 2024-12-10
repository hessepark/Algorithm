import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

	public static int list[][];
	public static boolean isVisited[];
	public static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int m = sc.nextInt();

		list = new int[n + 1][n + 1];
		isVisited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			list[node1][node2] = 1;
			list[node2][node1] = 1;
		}

		int count = 0;

		for (int i = 1; i < n + 1; i++) {
			if (!isVisited[i]) {
				// DFS(i);
				DFS2(i);
				count++;
			}
		}

		System.out.println(count);

	}

	public static void DFS(int node) {
		isVisited[node] = true;

		for (int i = 1; i < n + 1; i++) {
			if (list[node][i] == 1 && !isVisited[i]) {
				DFS(i);
			}
		}
	}

	public static void BFS(int node) {
		Deque<Integer> q = new ArrayDeque<>();
		isVisited[node] = true;
		q.addLast(node);

		while (!q.isEmpty()) {
			int num = q.removeFirst();
			for (int i = 1; i < n + 1; i++) {
				if (list[num][i] == 1 && !isVisited[i]) {
					q.addLast(i);
					isVisited[i] = true;
				}
			}
		}
	}
	
	public static void DFS2(int node) {
		Deque<Integer> stack = new ArrayDeque<>();
		isVisited[node] = true;
		stack.addLast(node);

		while (!stack.isEmpty()) {
			int num = stack.removeLast();
			for (int i = 1; i < n + 1; i++) {
				if (list[num][i] == 1 && !isVisited[i]) {
					stack.addLast(i);
					isVisited[i] = true;
				}
			}
		}
	}

}