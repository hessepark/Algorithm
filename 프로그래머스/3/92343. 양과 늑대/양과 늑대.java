import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        boolean visited[] = new boolean[info.length];
        
        visited[0]=true; // 루트에는 항상 양
        
        return dfs(visited, info, edges, 1, 0);
    }
    
    public static int dfs(boolean[] visited, int[] info, int[][] edges, int sheep,int wolf){
        
        if(sheep==wolf){
            return sheep;
        }
        
        int maxSheep=sheep;
        
        for(int i=0;i<edges.length;i++){
            int parent=edges[i][0];
            int child=edges[i][1];
            
            if(visited[parent]&&!visited[child]){
                
                visited[child]=true;
                
                if(info[child]==0){
                    maxSheep=Math.max(maxSheep,dfs(visited,info,edges,sheep+1,wolf));
                }
                
                if(info[child]==1){
                    maxSheep=Math.max(maxSheep,dfs(visited,info,edges,sheep,wolf+1));
                }
                
                visited[child]=false;
                
            }
            
        }
        
        return maxSheep;
        
        
    }
    
    
}