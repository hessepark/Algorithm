import java.io.*;
import java.util.*;

class Solution {
    
    public static int dr[]={-1,0,1,0};
    public static int dc[]={0,1,0,-1};
    public static int visited[][];
    
    public int solution(int[][] maps) { //maps 배열 인덱스는 0베이스라는 것에 주의하자.
    
        visited=new int[maps.length+1][maps[0].length+1];
        
        bfs(maps);
        
        if(visited[maps.length][maps[0].length]==0){
            return -1;
        }
        
        return visited[maps.length][maps[0].length];

    }
    
    public static void bfs(int[][] maps){
        
        ArrayDeque<Point>q = new ArrayDeque<>();
        q.add(new Point(1,1));
        visited[1][1]=1;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for(int i=0;i<4;i++){
                int nr=now.r+dr[i];
                int nc=now.c+dc[i];
                
                if(nc==0||nr==0||nc==maps[0].length+1||nr==maps.length+1){
                    continue;
                }
                
                if(visited[nr][nc]==0&&maps[nr-1][nc-1]==1){
                    q.add(new Point(nr,nc));
                    visited[nr][nc]=visited[now.r][now.c]+1;
                }
                
                
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
