import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static int ans;
    
    public int solution(int n, int[][] computers) {
        ans = 0;
        
        //연결이 끊기면 answer++;
        
        isVisited=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
            ans++;
            dfs(i,computers);
            //System.out.println(i);
            }
        }
        
        return ans;
    }
    
    public static void dfs(int num,int[][] computers) {
        
        isVisited[num]=true;
        
        for(int i=0;i<computers[num].length;i++){
            if(!isVisited[i]&&computers[num][i]==1){
               
                dfs(i,computers);        
            }
        }
        
    }
    
}