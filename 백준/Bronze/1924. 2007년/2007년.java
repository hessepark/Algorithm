import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN" }; //시작을 맨 앞에
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int days=0;
		
		for(int i=0;i<x-1;i++) {
			days+=month[i];
		}
		
		days+=y;
		
		System.out.println(week[(days-1)%7]);
		
		
	}
}