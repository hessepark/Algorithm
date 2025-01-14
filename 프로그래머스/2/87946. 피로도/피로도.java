import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static int max;
    
    public int solution(int k, int[][] dungeons) {
        
        isVisited = new boolean[dungeons.length];
        max=Integer.MIN_VALUE;
        
        dfs(k,0,dungeons); //현재 피로도, 깊이, 던전
        
        return max;
    }
    
    public static void dfs(int cur,int depth,int[][]dungeons){
    
        max=Math.max(depth,max);
        
        for(int i=0;i<dungeons.length;i++){
            if(!isVisited[i]&&cur>=dungeons[i][0]){
                isVisited[i]=true;
                dfs(cur-dungeons[i][1],depth+1,dungeons);
                isVisited[i]=false;
            }
        }
        
        
    }
    
    
}