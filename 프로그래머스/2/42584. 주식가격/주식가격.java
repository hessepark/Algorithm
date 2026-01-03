import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<prices.length;i++) {
            while(!q.isEmpty()&&prices[i]<prices[q.peekLast()]) {
                    answer[q.peekLast()]=i-q.pollLast();       

            }
            q.addLast(i);
        }
        
        while(!q.isEmpty()) {
            answer[q.peekLast()]= prices.length-q.pollLast()-1;
        }
        
        return answer;
    } 
}