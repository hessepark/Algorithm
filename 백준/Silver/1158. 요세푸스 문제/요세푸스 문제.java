import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i < N + 1; i++) {
			list.add(i);
		}

		int ans[] = new int[N];
		int currentIndex = 0;

		for (int i = 0; i < N; i++) {
			currentIndex = (currentIndex + K - 1) % list.size();
			ans[i] = list.remove(currentIndex);
		}

		System.out.print("<");

		for (int i = 0; i < N; i++) {
			System.out.print(ans[i]);
			if (i != N - 1)
				System.out.print(", ");
		}

		System.out.println(">");

	}
}