import java.util.ArrayList;
import java.util.Scanner;

class Main {

	public static int n, m;
	public static ArrayList<Integer> list[];
	public static boolean isVisited[];
	public static int praise[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		list = new ArrayList[n + 1];
		isVisited = new boolean[n + 1];
		praise = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			int n = sc.nextInt();
			if (n == -1) {
				continue;
			}

			list[n].add(i + 1);
			list[i + 1].add(n);

		}

		for (int i = 0; i < m; i++) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			praise[n] += w;
		}

		dfs(1);
		
		for(int i=1;i<=n;i++) {
			System.out.print(praise[i]+" ");
		}

	}

	public static void dfs(int num) {
		isVisited[num] = true;
		for(int child:list[num]) {
			if(!isVisited[child]) {
				isVisited[child]=true;
				praise[child]+=praise[num];
				dfs(child);
			}
		}
	}
}