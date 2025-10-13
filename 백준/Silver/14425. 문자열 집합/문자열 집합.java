import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int M = sc.nextInt();

		String arr[] = new String[N];

		for (int i = 0; i < N; i++) {
			String word = sc.next();
			arr[i]=word;
		}
		
		Arrays.sort(arr);
		
		//System.out.println(Arrays.toString(arr));
		
		int cnt=0;
		
		for(int i=0;i<M;i++) {
			String word = sc.next();
			if(Arrays.binarySearch(arr, word)>=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

		

	}
}