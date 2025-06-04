import java.util.*;
import java.io.*;
class Solution {
    public static boolean visited[];
    public int solution(int[] info, int[][] edges) {
        
        visited=new boolean[info.length];
        
        visited[0]=true;
        
        return dfs(info,edges,1,0);
    }
    
    public static int dfs(int[] info, int[][] edges, int sheep, int wolf){
    
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
                    maxSheep=Math.max(maxSheep,dfs(info,edges,sheep+1,wolf));
                }
                else{
                    maxSheep=Math.max(maxSheep,dfs(info,edges,sheep,wolf+1));
                }
                
                visited[child]=false;
                
            }
        }
        
        return maxSheep;
        
    }
    
}