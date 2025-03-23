import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static int arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr=new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			arr[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			int num =sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(num==0) {
				union(a,b);
			}
			else {
				boolean result = checkSame(a,b);
				if(result) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			
			//System.out.println(Arrays.toString(arr));
		}
	}


	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a>b) {
			arr[a]=b;
		}
		else {
			arr[b]=a;
		}
		
	}
	
	private static int find(int n) {
		if(arr[n]==n) {
			return n;
		}
		return arr[n]=find(arr[n]);
	}


	private static boolean checkSame(int a, int b) {
		if(find(a)==find(b)) {
			return true;
		}
		return false;
	}

}