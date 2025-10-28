import java.util.*;
import java.io.*;

class Solution {
    
    public static int minDiff;
    
    public int solution(int n, int[][] wires) {
        minDiff=Integer.MAX_VALUE;
        
        ArrayList<Integer>list[] = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire:wires) {
            int a = wire[0];
            int b = wire[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        boolean isVisited[]=new boolean[n+1];
        
        dfs(isVisited,list,n,1);
        
        return minDiff;
    }
    
    public static int dfs(boolean[] isVisited, ArrayList<Integer>list[], int n,int num) {
        
        int cnt=1;
        isVisited[num]=true;
        
        for(int node:list[num]) {
            if(!isVisited[node]){
                cnt+=dfs(isVisited,list,n,node);
            }
        }
        
        minDiff=Math.min(minDiff, Math.abs(cnt-(n-cnt)));
        
        return cnt;
        
    }
}
