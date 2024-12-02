import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();

		while (true) {
			int n = sc.nextInt();
			if (n == -1)
				break;
			if (q.size() < N && n > 0)
				q.add(n);
			else if (n == 0) {
				q.remove();
			}
		}
		
		int count = q.size();

		if (q.isEmpty())
			System.out.println("empty");

		else {
			for (int i = 0; i <count; i++) {
				System.out.println(q.remove());
			}
		}

	}
}