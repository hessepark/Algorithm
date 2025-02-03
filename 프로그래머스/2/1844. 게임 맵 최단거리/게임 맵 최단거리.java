import java.util.*;
import java.io.*;

class Solution {
    
    public static int visited[][];
    public static ArrayDeque<Point> q;
    public static int dr[]= {-1,0,1,0};
    public static int dc[]= {0,1,0,-1};
    
    public int solution(int[][] maps) {
        
        visited=new int[maps.length+1][maps[0].length+1];
        q = new ArrayDeque<>();
        q.add(new Point(1,1));
        visited[1][1]=1;
        bfs(maps);
        
        if(visited[maps.length][maps[0].length]==0){
            return -1;
        }
        
        return visited[maps.length][maps[0].length];
    }
    
    public static void bfs(int[][] maps){
        
        while(!q.isEmpty()){
            
            Point now = q.poll();
            
            for(int i=0;i<4;i++){
                int nr=dr[i]+now.r;
                int nc=dc[i]+now.c;
                
                if(nr>maps.length||nc>maps[0].length||nr<1||nc<1||maps[nr-1][nc-1]==0||visited[nr][nc]!=0){
                    continue;
                }
                
                q.add(new Point(nr,nc));
                visited[nr][nc]=visited[now.r][now.c]+1;
                
            }
            
        }
        
    }
}

class Point {
    int r;
    int c;
    public Point(int r,int c){
        this.r=r;
        this.c=c;
    }
}