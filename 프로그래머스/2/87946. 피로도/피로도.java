import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static int max;
    
    public int solution(int k, int[][] dungeons) {
        max=Integer.MIN_VALUE;
        
        isVisited = new boolean[dungeons.length];
        
        dfs(k,0,dungeons);
        
        return max;
    }
    
    public static void dfs(int cur,int depth,int[][] dungeons){
        
        max=Math.max(max,depth);
        
        if(depth==dungeons.length){
            return;
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(!isVisited[i]){
                if(cur>=dungeons[i][0]){
                    isVisited[i]=true;
                    dfs(cur-dungeons[i][1],depth+1,dungeons);
                    isVisited[i]=false;
                }
            }
            
        }
        
    }
    
}