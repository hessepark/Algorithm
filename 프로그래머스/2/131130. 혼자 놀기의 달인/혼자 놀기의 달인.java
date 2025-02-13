import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    //public static ArrayList<Integer> list;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        PriorityQueue<Integer>q = new PriorityQueue<>((o1,o2)->(Integer.compare(o2,o1)));
        isVisited = new boolean[cards.length+1];
        
        for(int i=0;i<cards.length;i++){
            if(isVisited[cards[i]]){
                continue;
            }
            
            int cur = cards[i];
            int cnt=0;
            
            while(!isVisited[cur]){
            
                cnt++;
                isVisited[cur]=true;
                
                cur=cards[cur-1];
                
                
            }
            
            q.add(cnt);
            
        }
        
        
        
        
        
        if(q.size()<2){
            return 0;
        }
        
        return q.poll()*q.poll();
        
    }
}