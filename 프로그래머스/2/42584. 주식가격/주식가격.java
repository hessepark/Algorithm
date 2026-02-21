import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer=new int[prices.length];
        
        ArrayDeque<Integer>q=new ArrayDeque<>();
        
        for(int i=0;i<prices.length;i++) {
            while(!q.isEmpty()&&prices[q.peekLast()]>prices[i]){
                int idx=q.pollLast();
                answer[idx]=i-idx;
            }
            q.addLast(i);
        }
        
        while(!q.isEmpty()){
            int idx=q.pollLast();
            answer[idx]=prices.length-idx-1;
        }
        
        return answer;
    }
}