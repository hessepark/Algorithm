import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int baseToIndex(char color) {
		if (color == 'B')
			return 0;
		else if (color == 'W')
			return 1;
		else
			return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maximumB = sc.nextInt();
		int minimumW = sc.nextInt();

		char blocks[] = sc.next().toCharArray();

		int maxLength = 0;

		int count[] = {0,0};

		int rightIndex = 0;

		for (int i = 0; i < N; i++) {

			while (rightIndex < N ) {

				if (blocks[rightIndex] == 'B') {

					if (count[baseToIndex(blocks[rightIndex])] == maximumB) {
						count[baseToIndex(blocks[i])]--;
						break;
					}

					count[baseToIndex(blocks[rightIndex++])]++;

				}

				else if (blocks[rightIndex] == 'W') {
					count[baseToIndex(blocks[rightIndex++])]++;
				}

				if (count[0] <= maximumB && count[1] >= minimumW) {
					maxLength = Math.max(maxLength, count[0] + count[1]);
				}

				//System.out.println(maxLength);

			}
		}

		System.out.println(maxLength);

	}
}