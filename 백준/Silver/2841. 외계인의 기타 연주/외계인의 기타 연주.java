import java.util.ArrayDeque;
import java.util.Scanner;

class Main { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int p = sc.nextInt();

		ArrayDeque<Integer> q[] = new ArrayDeque[n + 1];//큐를 독립적으로 만들어서 차근차근 풀면 된다.

		for (int i = 1; i < n + 1; i++) {
			q[i] = new ArrayDeque<>();
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			int line = sc.nextInt();
			int pret = sc.nextInt();

			while (!q[line].isEmpty() && q[line].peekLast() > pret) {
				q[line].pollLast();
				cnt++;
			}

			if (q[line].isEmpty() || q[line].peekLast() != pret) {
				q[line].add(pret);
				cnt++;
			}

			//System.out.println(q[line]);
			//System.out.println(cnt);

		}

		System.out.println(cnt);

	}
}