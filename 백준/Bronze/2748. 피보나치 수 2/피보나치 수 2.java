import java.util.Scanner;

class Main {

	public static long cache[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		cache = new long[n + 1];

		System.out.println(fibo(n));
	}

	public static long fibo(int num) {

		if(cache[num]!=0) {
			return cache[num];
		}
		
		
		if (num == 1 || num == 2) {
			return 1;
		}

		cache[num] = fibo(num-1) + fibo(num-2);
		return cache[num];
	}
}