import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        answer = new int[prices.length];
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<prices.length;i++) {
            while(!q.isEmpty()){
                int j = q.peekLast();
                if(prices[j]>prices[i]){
                    answer[j]=i-j;
                    q.pollLast();
                }
                else{
                    break;
                }
            }
            q.addLast(i);
        }
        
        while(!q.isEmpty()){
            int num = q.pollLast();
            answer[num]=prices.length-num-1;
        }
        
        return answer;
    }
}