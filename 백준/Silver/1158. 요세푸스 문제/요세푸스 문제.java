import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		int answer[]=new int[n];
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<k;j++) {
				q.add(q.poll());
			}
			answer[i]=q.poll();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0;i<answer.length;i++) {
			if(i>0) {
				sb.append(", ");
			}
			sb.append(answer[i]);
		}
		sb.append(">");
		
		System.out.println(sb);
		
		
	}
}