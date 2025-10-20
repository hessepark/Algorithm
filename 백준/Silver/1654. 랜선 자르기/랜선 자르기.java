import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		int arr[] = new int[k];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		long length = find(arr, n);
		
		System.out.println(length);
	}
	
	public static long find(int[] arr, int n) {
		
		long l=0;
		long r=Integer.MAX_VALUE;
		long ans=-1;
		
		while(l<=r) {
			long mid=(l+r)/2;
			
			//System.out.println("l 출력: "+l+" r 출력: " + r);
			
			if(count(arr,mid)>=n) {
				l=mid+1;
				ans=mid;
			}
			else {
				r=mid-1;
			}
		}
		
		return ans;
	}
	
	public static long count(int[] arr,long mid) {
		
		long sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i]/mid;
		}
		
		//System.out.println("mid 출력: "+mid);
		//System.out.println("개수 출력: "+sum);
		
		return sum;
		
	}
	

}