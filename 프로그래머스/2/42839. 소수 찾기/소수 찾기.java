import java.util.HashSet;

class Solution {

	// 시작점에서부터 다 본다.

	public static HashSet<Integer> set = new HashSet<>();
	public static boolean isVisited[];
	public static int ans;

	public int solution(String numbers) {
		ans = 0;

		isVisited = new boolean[numbers.length()];

		dfs(0,0, numbers);

		return ans;
	}

	public static void dfs(int num,int depth,String numbers) {

		//System.out.println(cur);

		if (isPrime(num)) {
			set.add(num);
			ans++;
		}
        
        if(depth==numbers.length()){
            return;
        }

		for (int i = 0; i < numbers.length(); i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				dfs(num*10+numbers.charAt(i)-'0',depth+1,numbers);
				//System.out.println("종료: " + numbers.charAt(i) + "종료 당시 cur:" + cur);
				isVisited[i] = false;
			}
			// isVisited[i]=false; 여기 들어가면 121 나온다. 이유는 1이 안 간 거 처리 돼버림
		}

	}

	public static boolean isPrime(int num) {

		if (num<=1||set.contains(num)) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;

	}
}