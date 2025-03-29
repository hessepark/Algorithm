import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1,o2));
        
        for(int i=0; i<scoville.length;i++){
            q.add(scoville[i]);
        }
        
        while(true){
            if(q.peek()>=K || q.size()==1)
                break;
            
            
            int n1 = q.poll();
            int n2 = q.poll();
            
            q.add(n1 + 2*n2);
            
            answer++;
            }
        
        if(q.peek()<K){
            answer=-1;
        }
            
         return answer;
        }
        
       
    }
