import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

	public static boolean[] check; // 갔는지 안 갔는지
	public static int[] student; // 이다솜파인지 누군지
	public static List<Integer> pick; // 조합 담을 리스트

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		student = new int[25];
		check = new boolean[25];
		pick = new ArrayList<>();

		int cnt = 0;

		for (int i = 0; i < 5; i++) {
			String str = sc.next();
			// System.out.println(str);
			for (int j = 0; j < 5; j++) {
				if (str.charAt(j) == 'Y') {
					student[cnt] = 1;
				} else if (str.charAt(j) == 'S') {
					student[cnt] = 0;
				}
				cnt++;
			}

		}
		int princess = nextPermutation(0);
		System.out.println(princess);

	}

	public static int nextPermutation(int studentNum) {

		if (pick.size() == 7) {
			int cnt = 0;

			for (int i = 0; i < 7; i++) {
				if (student[pick.get(i)] == 0)
					cnt++;
			}

			if (cnt < 4)
				return 0;

			for (int i = 0; i < 7; i++) {
				check[i] = false;
			}

			if (dfs(0) == 7) {
				return 1;
			}

			return 0;

		}

		if (studentNum >= 25)
			return 0;

		int ret = 0;

		ret += nextPermutation(studentNum + 1);
		pick.add(studentNum);
		ret += nextPermutation(studentNum + 1);
		pick.remove(pick.size() - 1);

		return ret;

	}

	public static boolean isFriend(int me, int you) {

		int diff = Math.abs(me - you);
		int max = Math.max(me, you);

		if (diff == 5) {
			return true;
		} else if (diff == 1 && max % 5 != 0) {
			return true;
		}
		return false;

	}

	public static int dfs(int studentNum) {
		int count = 1;
		check[studentNum] = true;

		int me = pick.get(studentNum);

		for (int i = 1; i < 7; i++) {
			int you = pick.get(i);
			if (!check[i] && isFriend(me, you)) {
				count += dfs(i);
			}
		}

		return count;

	}
}