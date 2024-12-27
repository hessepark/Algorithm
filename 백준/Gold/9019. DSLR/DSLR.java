import java.util.ArrayDeque;
import java.util.Scanner;

class Main { // 1. subString 사용 (list 안씀)
				// 2. visited로 안 간 숫자만 q에 넣음 (q 배열 줄어

	public static char alpha[] = { 'D', 'S', 'L', 'R' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			String start = sc.next();
			String target = sc.next();

			// 방문 체크 배열
			boolean[] visited = new boolean[10000];

			ArrayDeque<Num> q = new ArrayDeque<>();
			q.add(new Num(start, ""));
			visited[Integer.parseInt(start)] = true; // 시작 숫자는 방문 처리

			String ans = "";

			while (!q.isEmpty()) {
				Num now = q.poll();

				if (Integer.parseInt(target) == Integer.parseInt(now.num)) {
					ans = now.word;
					break;
				}

				for (int i = 0; i < 4; i++) {

					while (now.num.length() < 4) { //4자리 맞춰주기
						now.num = "0" + now.num;
					}

					int num = Integer.parseInt(now.num);

					if (i == 0) {
						num = num * 2;
						if (num > 9999) {
							num %= 10000;
						}
						// System.out.println(num);

					} else if (i == 1) {
						num = num - 1;
						if (num == -1) {
							num = 9999;
						}
						// System.out.println(num);

					} else if (i == 2) {
						String rotated = now.num.substring(1) + now.num.charAt(0);
						num = Integer.parseInt(rotated);
					} else if (i == 3) {
						String rotated = now.num.charAt(now.num.length() - 1)
								+ now.num.substring(0, now.num.length() - 1);
						num = Integer.parseInt(rotated);
					}

					// 방문하지 않은 숫자만 큐에 추가
					if (!visited[num]) {
						visited[num] = true;
						q.add(new Num(Integer.toString(num), now.word + alpha[i]));
					}

				}

			}

			System.out.println(ans);

		}

	}
}

class Num {
	String num;
	String word;

	public Num(String num, String word) {
		this.num = num;
		this.word = word;
	}

}