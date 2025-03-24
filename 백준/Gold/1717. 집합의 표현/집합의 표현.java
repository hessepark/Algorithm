import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static int parent[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parent=new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			int num = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			
			
			if(num==0) {
				union(a,b);
			}
			else {
				if(checkSame(a,b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
			
			//System.out.println(Arrays.toString(parent));
			
		}
		
	}
	
	public static void union(int a,int b) {
		a = find(a);
		b = find(b);
		
		//System.out.println("a:"+a+","+"b:"+b);
		
		if(a<b) {
			parent[b]=a;
		}
		else {
			parent[a]=b;
		}
	}
	
	public static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		return parent[n]= find(parent[n]);
	}
	
	public static boolean checkSame(int a,int b) {
		if(find(a)==find(b)) {
			return true;
		}
		return false;
	}
}