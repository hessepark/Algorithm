import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public String solution(int[] numbers) {
		ArrayList<String> answer = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			answer.add(numbers[i]+"");
		}

		Collections.sort(answer, (o1, o2) -> (o2+o1).compareTo(o1+o2));

		//System.out.println(answer);

		if (answer.get(0).equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i));
		}

		return sb.toString();
	}
}