import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static boolean isVisited[];
	public static char alpha[] = { 'D', 'S', 'L', 'R' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			int start = sc.nextInt();
			int target = sc.nextInt();

			isVisited = new boolean[10000];

			ArrayDeque<Num> q = new ArrayDeque<>();
			q.add(new Num(start, new StringBuilder()));
			isVisited[start] = true;
			int cnt = 0;
			while (!q.isEmpty()) {
				
				cnt++;

				Num now = q.poll();
				//System.out.println(cnt+" "+now.word);

				if (now.num == target) {
					System.out.println(now.word);
					break;
				}

				int[] nextN = { now.calD(), now.calS(), now.calL(), now.calR() };
				// 이렇게 안 하면 아래에서 if(i==0)이런 식으로 작업해줘야 할 거 같다.

				for (int i = 0; i < 4; i++) {
					//StringBuilder sb = now.word;
					//System.out.println(sb);
//					if (i == 2) {
//						System.out.println(++cnt + ": " + nextN[i]);
//					}
					if (!isVisited[nextN[i]]) {
						isVisited[nextN[i]] = true;
						q.add(new Num(nextN[i], new StringBuilder(now.word).append(alpha[i])));
					}
				}

			}
		}

	}
}

class Num {
	int num;
	StringBuilder word;

	public Num(int num, StringBuilder word) {
		this.num = num;
		this.word = word;
	}

	int calD() {
		return (num * 2) % 10000;
	}

	int calS() {
		// num = num - 1; 여기서 값 바꾸면 안 됨
//		if (num == -1) {
//			num = 9999;
//		}
		return num - 1 == -1 ? 9999 : num - 1;
	}

	// 1234->2341 //0123->1230//
	int calL() {
		return (num % 1000) * 10 + num / 1000;
	}

	// 1234->4123 // 0123->3012
	int calR() {
		return (num % 10) * 1000 + num / 10;
	}
}