import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<prices.length;i++){
            while(!q.isEmpty()&&prices[i]<prices[q.peekLast()]){
                int idx=q.peekLast();
                answer[idx]=i-idx;
                q.pollLast();
            }
            q.addLast(i);
        }
        
        //System.out.println(q);
        
        while(!q.isEmpty()){
            int idx=q.pollLast();
            answer[idx]=prices.length-idx-1;
        }
        
        return answer;
    }
}