import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static ArrayList<Integer> list[];
	public static int n, r, q;
	public static int ans[];
	public static boolean isVisited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		r=sc.nextInt();
		q=sc.nextInt();

		list = new ArrayList[n + 1];
		ans = new int[n+1];
		isVisited = new boolean[n+1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		find(r);
		
		for(int i=0;i<q;i++) {
			int u = sc.nextInt();
			
			System.out.println(ans[u]);
		}

	}
	
	public static int find (int num) {
		
		isVisited[num]=true;
		int cnt = 1;
		
		for(int child:list[num]) {
			if(!isVisited[child]) {
				cnt+=find(child);
			}
		}
		
		//System.out.println(num);
		//System.out.println(Arrays.toString(isVisited));
		
		return ans[num]=cnt;
		
	}
	
}