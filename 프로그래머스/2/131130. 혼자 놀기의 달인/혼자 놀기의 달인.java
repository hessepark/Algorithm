import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer> list;
    public static int depth;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        list = new ArrayList<>();
        isVisited = new boolean[cards.length+1];
        
        for(int i=0;i<cards.length;i++){
            if(!isVisited[cards[i]]){
                depth=1;
                dfs(cards,cards[i]);
                list.add(depth);
            }
        }
        
        if(list.size()==1){
            return 0;
        }
        
        Collections.sort(list,Collections.reverseOrder());
        return list.get(0)*list.get(1);
        
    }
    
    public static void dfs(int[] cards, int num){
        
        isVisited[num]=true;
        int next = cards[num-1];
        
        if(!isVisited[next]){
            depth++;
            dfs(cards,next);
        }
        
        return;
    }
}