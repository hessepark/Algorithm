import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String num[] = br.readLine().split(" ");

		int ans[] = new int[N];
		int stack[] = new int[N];
		int topIndex = -1;

		for (int i = N - 1; i >= 0; i--) {
			while (topIndex >= 0 && stack[topIndex] <= Integer.parseInt(num[i]))
				topIndex--;
			ans[i] = topIndex < 0 ? -1 : stack[topIndex];
			stack[++topIndex] = Integer.parseInt(num[i]);

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}

		System.out.println(sb);

	}
}