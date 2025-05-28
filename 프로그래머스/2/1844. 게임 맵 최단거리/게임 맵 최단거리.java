import java.util.*;
import java.io.*;

class Solution {
    
    public static int dr[] = {-1,0,1,0};
    public static int dc[] = {0,1,0,-1};
    public static int visited[][];
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        visited = new int[n][m];
        
        ArrayDeque<Pos>q = new ArrayDeque<>();
        q.add(new Pos(0,0));
        visited[0][0]=1;
        
        while(!q.isEmpty()){
            
            Pos now = q.poll();
            if(now.r==n-1&&now.c==m-1){
                return visited[now.r][now.c];
            }
            
            for(int k=0;k<4;k++){
                int nr = now.r+dr[k];
                int nc = now.c+dc[k];
                
                if(nr<0||nc<0||nr>=n||nc>=m){
                    continue;
                }
                
                if(visited[nr][nc]==0&&maps[nr][nc]==1){
                    q.add(new Pos(nr,nc));
                    visited[nr][nc]=visited[now.r][now.c]+1;
                }
            }
            
        }
        
        
        return -1;
    }
}

class Pos {
    int r;
    int c;
    public Pos(int r,int c){
        this.r=r;
        this.c=c;
    }
}