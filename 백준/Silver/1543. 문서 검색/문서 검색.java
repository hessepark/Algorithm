import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		
		String b = sc.nextLine();
		
		int cnt=0;

		while(a.indexOf(b)>=0) {
			
			cnt++;
			a=a.substring(a.indexOf(b)+b.length());
			
			//System.out.println(a);
		}
		
		System.out.print(cnt);

	}
	


}