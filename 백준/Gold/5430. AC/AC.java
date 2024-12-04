import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			String p = br.readLine();

			int n = Integer.parseInt(br.readLine());

			Deque<Integer> q = new LinkedList<>();

			String arr = br.readLine();

			String arrm = arr.substring(1, arr.length() - 1);

			StringTokenizer st = new StringTokenizer(arrm, ",");

			boolean isValid = true;

			boolean isFlipped = false;

			// System.out.println(arrm);

			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
			}

			// System.out.println(q.size());

			for (int i = 0; i < p.length(); i++) {

				if (p.charAt(i) == 'D') {
					if (q.isEmpty()) {
						isValid = false;
						break;
					} else {
						if (isFlipped)
							q.pollLast();
						else
							q.pollFirst();
					}

				} else
					isFlipped = !isFlipped;

			}

			if (isValid == true) {
				bw.write("[");

				int count = q.size();

				for (int i = 0; i < count; i++) {
					if (i > 0)
						bw.write(",");
					if (isFlipped)
						bw.write(q.removeLast() + "");
					else
						bw.write(q.removeFirst() + "");
				}

				bw.write("]");

				bw.write("\n");

			} else
				bw.write("error\n");
		}

		bw.flush();

	}
}