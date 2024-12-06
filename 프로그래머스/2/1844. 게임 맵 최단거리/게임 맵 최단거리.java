import java.util.*;
import java.io.*;

class Solution {
    
    public static int[][] visited;
    public static int[] dr={-1,0,1,0};
    public static int[] dc={0,1,0,-1};
    public static int n,m;
    
    public int solution(int[][] maps) {
        
        n=maps.length;
        m=maps[0].length;
        
        visited=new int[n+1][m+1];
        
        ArrayDeque<Point>q = new ArrayDeque<>();
        q.add(new Point(1,1));
        visited[1][1]=1;
        
        while(!q.isEmpty()){
            Point now =q.poll();
            
            for(int i=0;i<4;i++){
            int nr = now.r+dr[i];
            int nc = now.c+dc[i];
            
            if(nr==0||nc==0||nr>n||nc>m){
                continue;
            }
            
            if(visited[nr][nc]==0&&maps[nr-1][nc-1]==1){ //안 가본 곳이고 갈 수 있으면. nr,nc 미로 보는 걸 한 칸 전 걸 보면 된다
                visited[nr][nc]=visited[now.r][now.c]+1;
                q.add(new Point(nr,nc));
            }
                
            }
            
        }
        
        if(visited[n][m]==0){
            visited[n][m]=-1;
        }
        
        return visited[n][m];
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