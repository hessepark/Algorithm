import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = sc.nextInt();

		while (tc-- > 0) {
			Deque<Character> leftQ = new LinkedList<>();
			Deque<Character> rightQ = new LinkedList<>();

			char arr[] = sc.next().toCharArray();

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '<') {
					if (!leftQ.isEmpty()) {
						rightQ.addLast(leftQ.removeLast());
					}
				}

				else if (arr[i] == '>') {
					if (!rightQ.isEmpty()) {
						leftQ.addLast(rightQ.removeLast());
					}
				}

				else if (arr[i] == '-') {
					if (!leftQ.isEmpty()) {
						leftQ.removeLast();
					}
				}

				else {
					leftQ.addLast(arr[i]);
				}
			}

			while (!leftQ.isEmpty()) {
				bw.write(leftQ.remove());
			}

			while (!rightQ.isEmpty()) {
				bw.write(rightQ.removeLast());
			}
			bw.write("\n");

		}
		bw.flush();

	}
}