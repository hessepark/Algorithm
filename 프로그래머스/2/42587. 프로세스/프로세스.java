import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer>q = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
        
        for(int i=0;i<priorities.length;i++){
            q.add(priorities[i]);
        }
        
        int cnt=0;
        boolean isFind=false;
        
        int now = q.poll();
        
        while(true){
            
            for(int i=0;i<priorities.length;i++){  

                if(now==priorities[i]){
                    //System.out.println(cnt);
                    cnt++;
                                  
                    if(location==i){
                        isFind=true;
                        break;
                    }
                    
                    now = q.poll();
                }
            }
            
            if(isFind){
                break;
            }
            
        }
        
        return cnt;
    }
}