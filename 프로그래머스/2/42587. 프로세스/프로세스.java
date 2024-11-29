import java.util.ArrayDeque;
import java.util.Iterator;

class process {
	int idx;
	int num;

	public process(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}

class Solution {
	public static int solution(int[] priorities, int location) {
		int answer = 0;

		ArrayDeque<process> q = new ArrayDeque<>();

		for (int i = 0; i < priorities.length; i++) {
			process pro = new process(i, priorities[i]);
			q.add(pro);
		}

		int cnt = 0;

		while (true) {
			int max = Integer.MIN_VALUE;
			Iterator<process> it = q.iterator();
			while (it.hasNext()) {
				max = Math.max(max, it.next().num);
			}

			while (q.peekFirst().num != max) {
				process pro = q.poll();
				q.add(pro);
			}

			process pro = q.poll();
			cnt++;
			if (pro.idx == location) {
				break;
			}

		}

		answer = cnt;

		return answer;
	}
	// public static void main(String[] args) {
	// 	int priorities[]= {1,1,9,1,1,1};
	// 	int location=0;
	// 	System.out.println(solution(priorities,location));
	// }
}