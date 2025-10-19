import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int c = sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int result = find(arr,c);
		
		System.out.print(result);
	}
	
	public static int find(int[] arr, int c) {
		
		int l =1;
		int r=arr[arr.length-1]-arr[0];
		int ans=-1;
		
		while(l<=r) {
			int m = (l+r)/2;
			
			if(isPossible(arr,m)>=c) {
				l=m+1;
				ans = m;
			}
			else {
				r=m-1;
			}
			
		}
		
		
		return ans;
		
		
	}
	
	public static int isPossible(int[] arr,int m) {
		
		int cnt=1;
		int pastX=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-pastX>=m) {
				pastX=arr[i];
				cnt++;
			}
		}
		
		return cnt;
		
	}
	
	

	// 공유기 개수 같거나 많으면 거리 늘이기, 아니면 줄이기



}
