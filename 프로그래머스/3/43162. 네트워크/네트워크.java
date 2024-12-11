import java.util.*;
import java.io.*;

class Solution {
    
    public static int ans;
    public static boolean isVisited[];
    
    public int solution(int n, int[][] computers) {
        
        ans = 0;
        isVisited=new boolean[n];
        
        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]){
                ans++;
                dfs(i,computers);
            }
        }
        
        return ans;
        
        
    }
    
    public static void dfs(int num,int[][] computers){
        isVisited[num]=true;
        
        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]&&computers[num][i]==1){ //안 가본 곳이고, 갈 수 있어야
                dfs(i,computers);
            }
        }
        
        
    }
}