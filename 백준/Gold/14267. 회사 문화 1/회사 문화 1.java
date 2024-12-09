import java.util.ArrayList;
import java.util.Scanner;

class Main {

	// 트리 만들고 내리칭찬하기

	public static int n, m;

	public static ArrayList<Integer> list[];
	//public static boolean[] isVisited;
	public static int[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		list = new ArrayList[n + 1];

		ans = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		//isVisited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			int n = sc.nextInt();
			if (i == 1)
				continue;
			list[n].add(i);
		}

//		for(int i=1;i<n+1;i++) {
//			System.out.println(list[i]);
//		}

		for (int i = 0; i < m; i++) {
			int num = sc.nextInt();
			int w = sc.nextInt();
			
			ans[num]+=w;
		}
		
		dfs(1);

		for (int i = 1; i < n + 1; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static void dfs(int num) {

		for (int next : list[num]) {
			ans[next]+=ans[num];
			dfs(next);
		}

	}
}