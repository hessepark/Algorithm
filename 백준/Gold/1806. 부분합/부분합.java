import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int currentSum = arr[0];
		int minimumLength = arr.length;
		int rightIndex = 0;

		int cnt = 1;

		boolean isPossible = false;

		for (int i = 0; i < N; i++) {
			while (currentSum < S && rightIndex < N - 1) {
				currentSum += arr[++rightIndex];
				cnt++;
				// System.out.println("current sum: " + currentSum + " cnt : " + cnt);
			}
			if (currentSum >= S && cnt <= minimumLength) {
				minimumLength = cnt;
				isPossible = true;
				// System.out.println("minimumLength: " + minimumLength);
			}
			currentSum -= arr[i];
			cnt--;
		}

		if (isPossible == false)
			minimumLength = 0;

		System.out.println(minimumLength);

	}
}