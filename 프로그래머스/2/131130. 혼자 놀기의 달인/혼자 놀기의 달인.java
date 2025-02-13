import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer> list;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        list = new ArrayList<>();
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
            
            list.add(cnt);
            
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
        System.out.println(list);
        
        if(list.size()<2){
            return 0;
        }
        
        return list.get(0)*list.get(1);
        
    }
}