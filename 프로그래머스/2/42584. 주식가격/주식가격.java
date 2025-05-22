import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        q.add(0);
        
        for(int i=1;i<prices.length;i++){
            while(!q.isEmpty()){
                if(prices[i]<prices[q.peekLast()]){
                    int num=q.pollLast();
                    answer[num]=i-num;
                }
                else{
                    break;
                }
            }
            q.add(i);
        }
        
        while(!q.isEmpty()){
            int idx = q.pollLast();
            answer[idx]=prices.length-idx-1;
        }
        
        return answer;
    }
}