import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int calculateCnt(int[] arr, int m) {

		int cnt = 1;
		int pastX = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - pastX >= m) {
				pastX = arr[i];
				cnt++;
			}
		}

		return cnt;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int C = sc.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int l = 1;
		int r = arr[arr.length - 1]-arr[0];
		int ans = -1;

		while (l <= r) {
			int m = (l + r) / 2;

			if (calculateCnt(arr, m) >= C) {
				ans = m;
				l = m + 1;
			}

			else {
				r = m - 1;
			}

		}
		System.out.println(ans);

	}
}