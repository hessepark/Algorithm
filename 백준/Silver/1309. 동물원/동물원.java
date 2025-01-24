import java.util.Scanner;

class Main {

	public static int L = 0;
	public static int R = 1;
	public static int N = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int d[][] = new int[3][n + 1];

		d[L][1] = 1;
		d[R][1] = 1;
		d[N][1] = 1;

		for (int i = 2; i < n + 1; i++) {
			d[L][i] = (d[R][i - 1] + d[N][i - 1]) % 9901;
			d[R][i] = (d[L][i - 1] + d[N][i - 1]) % 9901;
			d[N][i] = (d[L][i - 1] + d[R][i - 1] + d[N][i - 1]) % 9901;
		}

		int sum = 0;

		for (int i = 0; i < 3; i++) {
			sum = (sum + d[i][n]) % 9901;
		}

		System.out.println(sum);

	}
}