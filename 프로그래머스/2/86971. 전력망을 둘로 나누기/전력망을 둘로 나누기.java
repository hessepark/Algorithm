import java.util.*;
import java.io.*;

class Solution {
    
    public static ArrayList<Integer>list[];
    public static boolean isVisited[];
    public static int min;
    
    public int solution(int n, int[][] wires) {
        min = Integer.MAX_VALUE;
        
        list=new ArrayList[n+1];
        
        for(int i=1;i<n+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            isVisited=new boolean[n+1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            int cnt=dfs(1);
            
            min=Math.min(min,Math.abs(cnt-(n-cnt)));
            
            list[a].add(b);
            list[b].add(a);
            
        }
        
        return min;
    }
    
    public static int dfs(int num){
        
        isVisited[num]=true;
        
        int cnt=1;
        
        for(int child:list[num]){
            if(!isVisited[child]){
            cnt+=dfs(child);
            }
        }
        
        return cnt;
        
    }
}