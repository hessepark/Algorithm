import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Main {

	static int v, e;
	static int[][] graph;
	static boolean[] visited;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();

		graph = new int[v + 1][v + 1];
		visited = new boolean[v + 1];

		for (int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int dst = sc.nextInt();

			graph[src][dst] = 1;
			graph[dst][src] = 1;
		}

		dfs2(1);

		System.out.println(cnt - 1);

	}

	public static void dfs(int node) {
		visited[node] = true;
		cnt++;
		for (int i = 1; i <= v; i++) {
			if (!visited[i] && graph[node][i] == 1) {
				dfs(i);
			}
		}
	}
	
	
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node]=true;
		
		while(!q.isEmpty()) {
			int now=q.poll();
			cnt++;
			for(int i=1;i<=v;i++) {
				if(!visited[i] && graph[now][i]==1) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
	}
	
	public static void dfs2(int node) {
		Stack<Integer> s = new Stack<>();
		s.push(node);
		visited[node]=true;
		
		while(!s.isEmpty()) {
			int now=s.pop();
			cnt++;
			for(int i=1;i<=v;i++) {
				if(!visited[i] && graph[now][i]==1) {
					s.push(i);
					visited[i]=true;
				}
			}
		}
	}
	
}