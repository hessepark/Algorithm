import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Process {
	int index;
	int priority;

	public Process(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}

}

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			ArrayDeque<Process> q = new ArrayDeque<>();

			Integer priorities[] = new Integer[n];

			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				priorities[i] = num;
				q.add(new Process(i, num));
			}

			Arrays.sort(priorities, Collections.reverseOrder());
			
			for(int i=0;i<priorities.length;i++) {
				
				
				while(priorities[i]!=q.peekFirst().priority) {
					q.add(q.poll());
				}
				
				if(m==q.peekFirst().index) {
					System.out.println(i+1);
					break;
				}
				
				q.poll();
				
				
			}
			

		}

	}
}
