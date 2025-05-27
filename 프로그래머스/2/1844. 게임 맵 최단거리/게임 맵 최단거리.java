import java.util.*;
import java.io.*;

class Solution {
    
    public static int dr[] = {-1,0,1,0};
    public static int dc[] = {0,1,0,-1};
    public static int isVisited[][];
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        isVisited = new int[n][m];
        
        ArrayDeque<Pos>q = new ArrayDeque<>();
        q.add(new Pos(0,0));
        isVisited[0][0]=1;
        
        while(!q.isEmpty()){
            
            Pos now = q.poll();
            
            if(now.r==n-1&&now.c==m-1){
                return isVisited[n-1][m-1];
            }
            
            for(int k=0;k<4;k++){
                
                int nr = dr[k]+now.r;
                int nc = dc[k]+now.c;
                
                if(nr<0||nc<0||nr>=n||nc>=m){
                    continue;
                }
                
                if(isVisited[nr][nc]==0&&maps[nr][nc]==1){
                    isVisited[nr][nc]=isVisited[now.r][now.c]+1;
                    q.add(new Pos(nr,nc));
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