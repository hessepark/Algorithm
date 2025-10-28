import java.util.*;
import java.io.*;

class Solution {
    
    public static int max;
    
    public int solution(int k, int[][] dungeons) {
        
        max = 0;
        
        boolean isVisited[]=new boolean[dungeons.length];
        
        dfs(k,dungeons,0,isVisited);
        
        return max;
    }
    
    public static void dfs(int k, int[][] dungeons, int depth,boolean[] isVisited) {
        
        max=Math.max(max,depth);
        
        if(depth==dungeons.length){
            return;
        }
            
            for(int i=0;i<dungeons.length;i++) {
                if(!isVisited[i]&&dungeons[i][0]<=k){
                    isVisited[i]=true;
                    dfs(k-dungeons[i][1],dungeons,depth+1,isVisited);
                    isVisited[i]=false;
                }
                
                
            }
            
        
    }
    
}