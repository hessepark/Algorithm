import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        answer=new int[prices.length];
        
        for(int i=0;i<prices.length;i++) {
            while(!q.isEmpty()&&prices[i]<prices[q.peekLast()]){
                int idx = q.pollLast();
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