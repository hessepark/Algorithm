import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        isVisited = new boolean[computers.length];
        
        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]){
                answer++;
                dfs(i,computers);
            }
        }
    
        return answer;
    }
    
    public void dfs(int num,int[][] computers){
        
        isVisited[num]=true;
        
        for(int i=0;i<computers.length;i++){
            if(!isVisited[i]&&computers[num][i]==1){
                dfs(i,computers);
            }
        }
        
    }
    
}