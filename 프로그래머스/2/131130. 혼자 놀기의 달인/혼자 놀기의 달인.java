import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] isVisited = new boolean[cards.length + 1];

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (int i = 0; i < cards.length; i++) {
            if (isVisited[cards[i]]) {
                continue;
            }

            int cur = cards[i];
            int cnt = 0;

            while (!isVisited[cur]) {
                cnt++;
                isVisited[cur] = true;
                cur = cards[cur - 1]; 
            }
            q.add(cnt);
        }

        if (q.size() < 2) { 
            return 0;
        }

        answer = q.poll() * q.poll();

        return answer;
    }
}
