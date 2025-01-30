import java.util.*;
import java.io.*;

class Solution {
    
    public static int dr[] = {-1,0,1,0};
    public static int dc[] = {0,1,0,-1};
    public static int visited[][];
   
    
    public int solution(int[][] maps) {
        
        visited=new int[maps.length+1][maps[0].length+1];
        
        bfs(maps);
        
        if(visited[maps.length][maps[0].length]==0){
            return -1;
        }
        
        return visited[maps.length][maps[0].length];
    }
    
    public static void bfs(int[][] maps){
    
    ArrayDeque<Point> q = new ArrayDeque<>();
    visited[1][1]=1;
    q.add(new Point(1,1));
    
    while(!q.isEmpty()){
        Point now = q.poll();
        for(int i=0;i<4;i++){
            int nr= dr[i]+now.r;
            int nc= dc[i]+now.c;
            
            if(nr==0||nc==0||nr==maps.length+1||nc==maps[0].length+1||maps[nr-1][nc-1]==0){
                continue;
            }
            
            if(visited[nr][nc]==0){
               visited[nr][nc]=visited[now.r][now.c]+1;
               q.add(new Point(nr,nc));
            }
        }
    }
    
    }
}



class Point {
    int r;
    int c;
    public Point(int r, int c){
        this.r=r;
        this.c=c;
    }
}