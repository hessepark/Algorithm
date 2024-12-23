import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {

	public static int dcol[] = { -1, 1 };
	public static int isVisited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		isVisited = new int[100001];

		Deque<Integer> q = new ArrayDeque<>();
		q.add(n);
		isVisited[n] = 1;

		while (!q.isEmpty()) {
			int present = q.poll();

			for (int i = 0; i < dcol.length; i++) {
				int next = present + dcol[i];

				if (next < 0 || next > 100000)
					continue;

				if (isVisited[next] == 0) {
					q.add(next);
					isVisited[next] = isVisited[present] + 1;
				}
			}

			int next = present * 2;

			if (next < 0 || next > 100000)
				continue;

			if (isVisited[next] == 0) {
				q.add(next);
				isVisited[next] = isVisited[present] + 1;
			}
		}

		System.out.println(isVisited[m] - 1);

	}
}