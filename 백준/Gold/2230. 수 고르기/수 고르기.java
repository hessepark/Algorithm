import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int r=0;
		int diff=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			while(arr[r]-arr[i]<m&&r<n-1) {
				r++;
			}
			if(arr[r]-arr[i]>=m) {
				diff=Math.min(diff, arr[r]-arr[i]);
			}
		}
		
		System.out.println(diff);
		
	
	}
	

}