import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<prices.length-1;i++){
            q.add(prices[i]);
            int idx=1;
            for(int j=i+1;j<prices.length-1;j++){
                if(q.peekLast()>prices[j]){
                    break;
                }
                idx++;
            }
            answer[i]=idx;
        }
        
        answer[answer.length-1]=0;
        
        
        
        
        return answer;
    }
}