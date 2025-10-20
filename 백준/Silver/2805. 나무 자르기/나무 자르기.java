import java.util.Scanner;

class Main{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[]=new int[n];
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max=Math.max(max, arr[i]);
		}
		
		int result = caculate(arr,m,max);
		
		System.out.println(result);
	}
	
	public static int caculate(int[] arr, int tLength,int max) {
		
		int l = 0;
		int r = max;
		int height=-1;
		
		while(l<=r) {
			int m = (l+r)/2;
			//System.out.println("m 출력:"+m);
			
			if(cut(arr,m)>=tLength) {
				l=m+1;
				height=m;
				//System.out.println("줄었음:"+height);
			}
			else {
				r=m-1;
			}
		}
		
		return height;
	}
	
	public static long cut(int[] arr,int m) {
		
		long sum=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]-m>0) {
				sum+=arr[i]-m;
			}
		}
		
		return sum;
		
	}
	

	
	
}

