import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static int n, k;
	public static int isVisited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		isVisited = new int[100001];

		n = sc.nextInt();
		k = sc.nextInt();

		bfs(n);

		System.out.println(isVisited[k]);
	}

	public static void bfs(int num) {

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(num);
		isVisited[num] = 0;

		while (!q.isEmpty()) {

			int now = q.poll();

			if (now == k) {
				return;
			}

			int arr[] = { now - 1, now + 1, now * 2 };

			for (int i = 0; i < 3; i++) {
				if (!isRange(arr[i])) {
					continue;
				}
				if (isVisited[arr[i]] == 0) {
					isVisited[arr[i]] = isVisited[now] + 1;
					q.add(arr[i]);
					//System.out.println(q);
				}
			}

		}

	}

	public static boolean isRange(int num) {
		return num >= 0 && num <= 100000;
	}
}