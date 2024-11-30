import java.util.Arrays;
import java.util.HashSet;

class Solution {

	public static boolean isVisited[];
	public static int length;
	public static int ans;
	public static char[] answer;
	public static String target = "";
	public static HashSet<Integer> set;

	public static int solution(String numbers) {
		ans = 0;
		length = numbers.length();
		target = numbers;
		set = new HashSet<>();

		for (int i = 1; i <= numbers.length(); i++) {
			answer = new char[i];
			isVisited = new boolean[length];
			dfs(0, i);
		}

		return ans;
	}

	public static void dfs(int depth, int l) {
		if (depth == l) {
			
			if(set.contains(Integer.parseInt(new String(answer)))) {
				return;
			}
			
			boolean isPossible = true;
			int num = Integer.parseInt(new String(answer));
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					isPossible = false;
					break;
				}
			}
			if (isPossible && Integer.parseInt(new String(answer)) != 1 && Integer.parseInt(new String(answer)) != 0) {
				System.out.println(Arrays.toString(answer));
				set.add(Integer.parseInt(new String(answer)));
				ans++;
			}
			return;
		}

		for (int i = 0; i < length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				answer[depth] = target.charAt(i);
				
				dfs(depth + 1, l);
                isVisited[i] = false;
			}
			
		}

	}
}