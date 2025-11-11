import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int AnB[] = new int[N + M];

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			AnB[i] = Integer.parseInt(st1.nextToken());
		}

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = N; i < N + M; i++) {
			AnB[i] = Integer.parseInt(st2.nextToken());
		}

		Arrays.sort(AnB);

		for (int i = 0; i < N + M; i++) {
			bw.write(AnB[i] + " ");
		}
		bw.flush();

	}
}