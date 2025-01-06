import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    
    public int solution(int n, int[][] computers) {
        int ans = 0;
        isVisited= new boolean[computers.length];
        
        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]){
                ans++;
                dfs(i,computers);
            }
        }
        
        return ans;
    }
    
    public static void dfs(int num,int[][] computers){
        
        isVisited[num] = true;
        
        for(int i=0;i<computers.length;i++){
            if(computers[num][i]==1&&!isVisited[i]){
                dfs(i,computers);
            }
        }
        
        
    }
}