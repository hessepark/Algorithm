import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int numArr[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> q = new LinkedList<>();
		boolean isValid = true;
		int num = 1;

		char ans[] = new char[200000]; // push,pop 1번씩 한다고 했을 때 100,000 * 2
		int ansIndex = 0; // +,- 저장하기 위한 인덱스

		for (int i = 1; i <= n; i++) {

			while (true) {

				if (!q.isEmpty()) // 비어있지 않을 때
					if (q.peekLast() == numArr[i]) { // 마지막 값이 numArr[i]랑 같다면
						q.removeLast(); // 스택에서 뺌
						ans[ansIndex++] = '-';
						break;// 찾으면 멈춤
					}

				if (num == n + 1) // ex)n이 8인데 9가 됐다면 넣지말고 멈춰야한다.
					break;

				q.addLast(num++);
				ans[ansIndex++] = '+';

			}

		}

		if (!q.isEmpty())
			isValid = false;

		if (isValid) {
			for (int i = 0; i < ansIndex; i++) {
				// System.out.println(ans[i]);
				bw.write(ans[i] + "\n");
			}
		} else {
			// System.out.println("NO");
			bw.write("NO" + "\n");
		}
		bw.flush();

	}
}