import java.util.Scanner;

class Main{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		int arr[]=new int[k];
		
		for(int i=0;i<k;i++) {
			arr[i] = sc.nextInt();
		}
		
		long maxLength = caculate(arr,n);
		
		System.out.println(maxLength);
	}
	
	public static long caculate(int[] arr,int target) {
		
		long l=0;
		long r=(1L<<32)-1;
		long length=-1;
		
		while(l<=r) {
			long m = (l+r)/2;
			
			if(cut(arr,m)>=target) {
				l=m+1;
				length=m;
			}
			else {
				r=m-1;
			}
		}
		
			return length;
		
	}
	
	public static long cut(int[] arr,long m) {
		
		long sum = 0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i]/m;
		}
		
		return sum;
		
		
	}
	
	
}

