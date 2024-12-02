import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();

		int lastValue = 0;

		while (N-- > 0) {

			// System.out.println("N: " + N);
			String cmd[] = br.readLine().split(" ");
			if (cmd[0].equals("push")) {
				lastValue = Integer.parseInt(cmd[1]);
				q.add(lastValue);
			}

			else if (cmd[0].equals("front")) {
				bw.write(q.isEmpty() ? "-1\n" : q.element() + "\n");
			}

			else if (cmd[0].equals("back")) {
				bw.write(q.isEmpty() ? "-1\n" : lastValue + "\n");
			}

			else if (cmd[0].equals("size")) {
				bw.write(q.size()+"\n");
			}

			else if (cmd[0].equals("empty")) {
				bw.write(q.isEmpty() ? "1\n" : "0\n");
			}

			else if (cmd[0].equals("pop")) {
				bw.write(q.isEmpty() ? "-1\n" : q.remove() + "\n");
			}
		}
		bw.flush();
	}
}