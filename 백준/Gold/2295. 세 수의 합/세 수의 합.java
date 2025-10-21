import java.util.HashSet;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				set.add(arr[i]+arr[j]);
			}
		}
		
		int max =Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(set.contains(arr[j]-arr[i])) {
					max=Math.max(max, arr[j]);
				}
			}
		}
		
		System.out.println(max);
		
	}
		

}