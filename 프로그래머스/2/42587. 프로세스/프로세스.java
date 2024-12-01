import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
         PriorityQueue<Integer>q = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
        
        for(int i=0;i<priorities.length;i++){
            q.add(priorities[i]);
        }
        
        //System.out.println(q);
        
        int idx=0;
        int num=q.poll();
        
        System.out.println(num);
        
        while(true){
            
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==num){
                    idx++;
                    
                    if(location==i){
                        return idx;
                    }
                    num=q.poll(); //같은 거 발견했을 때만 poll
                }
               
            }
        
    

    }
}
}