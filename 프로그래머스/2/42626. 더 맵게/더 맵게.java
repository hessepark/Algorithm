import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length;i++){
            q.add(scoville[i]);
        }
        
        while(true){
            
            if(q.size()==1||q.peek()>=K){
                break;
            }
            
            int n1 = q.poll();
            int n2 = q.poll()*2;
            
            q.add(n1+n2);
            answer++;
            
        }
        
        if(q.peek()<K){
            answer=-1;
        }
        
        return answer;
    }
}