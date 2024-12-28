import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	// 만든 숫자 다시 안 만든다.
	// substring으로 회전한다.
	// 4자리 안 되면 4자리 맞춰준다.

	public static boolean isVisited[];
	public static char alpha[] = { 'D', 'S', 'L', 'R' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			String start = sc.next();
			String target = sc.next();

			isVisited = new boolean[10000];

			ArrayDeque<Num> q = new ArrayDeque<>();
			q.add(new Num(start, ""));
			isVisited[Integer.parseInt(start)] = true;

			while (!q.isEmpty()) {

				Num now = q.poll();

				if (now.num.equals(target)) {
					System.out.println(now.word);
					break;
				}

				while (now.num.length() < 4) {
					now.num = '0' + now.num;
				}

				// int num = Integer.parseInt(now.num);

				for (int i = 0; i < 4; i++) {

					int num = Integer.parseInt(now.num); // 이거 여기서 해줘야함.

					if (i == 0) {
						num = num * 2;
						if (num > 9999) {
							num %= 10000;
						}
						// System.out.println(num);
					}

					else if (i == 1) {
						num = num - 1;
						if (num == -1) {
							num = 9999;
						}
						// System.out.println(num);
					}

					else if (i == 2) {
						String str = now.num.substring(1) + now.num.charAt(0);
						// String str = now.num.substring(1) + now.num.charAt(0);
						num = Integer.parseInt(str);
						// System.out.println("i==2 "+num);
					}

					else if (i == 3) {
						String str = now.num.charAt(now.num.length() - 1) + now.num.substring(0, now.num.length() - 1);
						num = Integer.parseInt(str);
						// System.out.println("i==3 "+num);
					}

					if (!isVisited[num]) {
						q.add(new Num(Integer.toString(num), now.word + alpha[i]));
						isVisited[num] = true;
					}
				}

			}

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