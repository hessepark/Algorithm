import java.util.*;
import java.io.*;

class Solution {
    
    public static int dr[] = {-1,0,1,0};
    public static int dc[] = {0,1,0,-1};
    public static int isVisited[][];
    
    public int solution(int[][] maps) { //map 0 based
        
        isVisited=new int[maps.length+1][maps[0].length+1]; //1 based
        
        bfs(maps);
        
        if(isVisited[maps.length][maps[0].length]==0){
            isVisited[maps.length][maps[0].length]=-1;
        }
        
        return isVisited[maps.length][maps[0].length];
    }
    
    public static void bfs(int[][] maps){

        ArrayDeque<Point>q = new ArrayDeque<>();
        q.add(new Point(1,1));
        isVisited[1][1]=1;
        
        while(!q.isEmpty()){
            
            Point now = q.poll();
            
            for(int i=0;i<4;i++){
                
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                
                if(nr==0||nc==0||nr==maps.length+1||nc==maps[0].length+1){
                    continue;
                }
                
                if(maps[nr-1][nc-1]==1&&isVisited[nr][nc]==0){
                    q.add(new Point(nr,nc));
                    isVisited[nr][nc]=isVisited[now.r][now.c]+1;
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