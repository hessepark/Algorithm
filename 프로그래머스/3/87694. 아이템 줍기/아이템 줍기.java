import java.util.*;
import java.io.*;

class Solution {
    
    public static int dr[]={-1,0,1,0};
    public static int dc[]={0,1,0,-1};
    public static boolean map[][];
    public static int ans;
    public static int isVisited[][];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        ans=0;
        
        map=new boolean[102][102];
        isVisited=new int[102][102];
        
        //모두 true;
        for(int data[]:rectangle){
        for(int i=data[1]*2;i<=data[3]*2;i++){
            for(int j=data[0]*2;j<=data[2]*2;j++){
                map[i][j]=true;
            }
        }
        }
            
        //테두리 제외 false;
        for(int data[]:rectangle){
        for(int i=data[1]*2+1;i<data[3]*2;i++){
            for(int j=data[0]*2+1;j<data[2]*2;j++){
                map[i][j]=false; //y축x축
            }
        }
        }
        
        bfs(characterX,characterY,itemX,itemY);
        
        return ans;
        
        
    }
    
    public static void bfs(int characterX, int characterY, int itemX,int itemY){
        
        int startX=characterX*2;
        int endX=itemX*2;
        int startY=characterY*2;
        int endY=itemY*2;
        
        ArrayDeque<Point>q = new ArrayDeque<>();
        q.add(new Point(startX,startY));
        isVisited[startY][startX]=1;
        
        int cnt=0;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            if(now.x==endX&&now.y==endY){
                ans= isVisited[now.y][now.x]/2;
                return;
            }
            
            for(int i=0;i<4;i++){
                int dx=now.x+dr[i];
                int dy=now.y+dc[i];
                
                if(dx==0||dy==0||dx==102||dy==102){
                    continue;
                }
                
               if (map[dy][dx]&&isVisited[dy][dx]==0) {
                   //map[dy][dx]=false;
                   isVisited[dy][dx]=isVisited[now.y][now.x]+1;
                    q.add(new Point(dx, dy));
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