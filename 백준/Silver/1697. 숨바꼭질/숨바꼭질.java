import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static int isVisited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		isVisited = new int[100001];

		int sp = sc.nextInt();
		int ep = sc.nextInt();

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(sp);
		isVisited[sp] = 0;

		while (!q.isEmpty()) {

			int now = q.poll();
			
			if(now==ep) {
				System.out.println(isVisited[now]);
				//System.out.println(q);
				break;
			}

			int next[] = { now + 1, now - 1, 2 * now };

			for (int i = 0; i < 3; i++) {

				if (next[i] < 0 || next[i] > 100000) {
					continue;
				}

				if (isVisited[next[i]] == 0) {
					q.add(next[i]);
					//System.out.println(q);
					isVisited[next[i]] = isVisited[now] + 1;
				}

			}

		}

	}
}