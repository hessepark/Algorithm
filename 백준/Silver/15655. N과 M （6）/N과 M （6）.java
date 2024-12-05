import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	//오름차순
	//증가하는 수열
	public static int n,m;
	public static int arr[];
	public static int ans[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		arr=new int[n];
		ans=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		perm(0,0); //시작점 추가
		
	}
	
	public static void perm(int depth,int pos) {
		
		if(depth==m) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				sb.append(ans[i]+" ");
			}
			System.out.println(sb);
		}
		
		for(int i=pos;i<n;i++) {
			ans[depth]=arr[i];
			perm(depth+1,i+1);
		}
		
		
	}
	
}