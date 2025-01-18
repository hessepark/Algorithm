import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int cnt=0;
		
		int[] money = new int[n];

		for (int i = 0; i < n; i++) {
			money[i] = sc.nextInt();
		}
		
		for(int i=n-1;i>=0;i--) {
			if(k/money[i]!=0) { //나눠지는 게 있으면
				cnt+=k/money[i]; //몫 더해주고
				k%=money[i]; //계산해서 남김
			}
		}
		
		System.out.println(cnt);
		
	}
}