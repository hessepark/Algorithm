import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer>list[];
    public static int min;
    
    public int solution(int n, int[][] wires) {
        
       
        list = new ArrayList[n+1];
        min = Integer.MAX_VALUE;
        
        for(int i=1;i<n+1;i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<wires.length;i++){
            int a= wires[i][0];
            int b= wires[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            isVisited=new boolean[n+1];
            
            int cnt=dfs(1);
            
            System.out.println(cnt);
            
            min=Math.min(min,Math.abs(cnt-(n-cnt)));
            
            list[a].add(b);
            list[b].add(a);
        }
        
        
        return min;
    }
    
    public static int dfs(int num){
        int cnt=1;
        
        isVisited[num]=true;
        
        for(int next:list[num]){
            if(!isVisited[next]){
                //System.out.println(next);
                isVisited[next]=true;
                cnt+=dfs(next);
            }
        }
        
        return cnt;
        
        
    }
    
}