import java.util.*;
import java.io.*;

//BFS
//1.맵 2배 확장
//2.갈 수 있는 미로 맵 만들기 (상하 반전)
//3.visited배열도 두 배


class Solution {
    
    public static int dx[]={0,1,0,-1};
    public static int dy[]={-1,0,1,0};
    
    public static int visited[][];
    public static boolean maze[][];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        visited = new int[102][102];
        maze = new boolean[102][102];
        
        for(int data[]:rectangle){
            for(int i=data[1]*2;i<=data[3]*2;i++){
                for(int j=data[0]*2;j<=data[2]*2;j++){
                    maze[i][j]=true;
                }
            }
        }
         for(int data[]:rectangle){
              for(int i=data[1]*2+1;i<data[3]*2;i++){
                for(int j=data[0]*2+1;j<data[2]*2;j++){
                    maze[i][j]=false;
                }
            }
         }
        
        bfs(rectangle, characterX, characterY,itemX,itemY);
        
        //System.out.println(visited[itemY*2][itemX*2]);
        
        return visited[itemY*2][itemX*2]/2;
    }
    
    public static void bfs(int[][] rectangle, int characterX, int characterY,int itemX,int itemY){
        
        int startX=characterX*2;
        int startY=characterY*2;
        int endX=itemX*2;
        int endY=itemY*2;
        
        ArrayDeque<Point>q=new ArrayDeque<>();
        q.add(new Point(startX,startY));
        visited[startY][startX]=0;
        
        
        while(!q.isEmpty()){
        
        Point now = q.poll();    
            
        for(int i=0;i<4;i++){
            int nx= now.x+dx[i];
            int ny= now.y+dy[i];
            
            if(nx==0||ny==0||nx==102||ny==102){
                continue;
            }
            
            if(maze[ny][nx]&&visited[ny][nx]==0){
                q.add(new Point(nx,ny));
                visited[ny][nx]=visited[now.y][now.x]+1;
            }
            
        }
            
        }
        
    }
    
}

class Point {
    int x;
    int y;
    
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}