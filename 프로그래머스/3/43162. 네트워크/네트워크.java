import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int cnt=0;
        
        boolean isVisited[]=new boolean[n];
        
        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]){
                dfs(computers,i,isVisited);
                cnt++;
            }
        }
        
        return cnt;
        
    }
    
    
    public static void dfs(int[][] computers, int n, boolean[] isVisited) {
        
        isVisited[n]=true;
        
        for(int i=0;i<computers.length;i++) {
            if(!isVisited[i]&&computers[n][i]==1){
                dfs(computers,i,isVisited);
            }
        }
        
        
    }
}