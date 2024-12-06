import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int N = str.length();

		char arr[] = new char[N + 1];

		System.arraycopy(str.toCharArray(), 0, arr, 1, N);

		int lasers[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			lasers[i] = lasers[i - 1];
			if (arr[i] == '(' && arr[i + 1] == ')') {
				lasers[i]++;
			}
		}

		int[] openIndex = new int[N + 1];
		int topIndex = -1;
		int ans = 0;

		for (int i = 1; i <= N; i++) {
			if (arr[i] == '(' && arr[i + 1] != ')') {
				openIndex[++topIndex] = i;
			} else if (arr[i] == ')' && arr[i - 1] != '(') {
				int open = openIndex[topIndex--];
				ans += lasers[i] - lasers[open - 1] + 1;
			}
		}

		System.out.println(ans);

	}
}