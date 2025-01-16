import java.util.Scanner;

class Main {

	public static long mem[] = new long[95];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(fibo(n));
	}

	public static long fibo(int n) {

		mem[1] = 1;

		for (int i = 1; i <= n; i++) {
			mem[i + 1] += mem[i];
			mem[i + 2] += mem[i];
		}

		return mem[n];

	}

}