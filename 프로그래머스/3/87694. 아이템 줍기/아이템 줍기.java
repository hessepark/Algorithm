import java.util.*;
import java.io.*;

//BFS
//1. ㄷ자 같은 거 때문에 배열 두 배로 확장
//2. 갈 수 있는 테두리 미로 만듦
//3. 최단거리 나오면 return

class Solution {
    
    public static int dx[]={0,1,0,-1};
    public static int dy[]={-1,0,1,0};
    public static boolean maze[][];
    public static ArrayList<Integer>result;
    public static int cnt;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        cnt=0;
        
        result=new ArrayList<>();

        maze=new boolean[102][102];
        
        for(int [] data:rectangle){
            for(int i=data[1]*2;i<=data[3]*2;i++){
                for(int j=data[0]*2;j<=data[2]*2;j++){
                    maze[i][j]=true;
                }
            }
        }
        
        //테두리만 남김
        for(int [] data:rectangle){
            for(int i=data[1]*2+1;i<data[3]*2;i++){
                for(int j=data[0]*2+1;j<data[2]*2;j++){
                    maze[i][j]=false;
                }
            }
        }
        
        dfs(characterX,characterY,itemX,itemY);
        
        return Math.min(result.get(0)/2,result.get(1)/2-result.get(0)/2);
        
    }
    
    public static void dfs(int characterX, int characterY, int itemX, int itemY){
        
        int startX=characterX*2;
        int startY=characterY*2;
        int endX=itemX*2;
        int endY=itemY*2;
        
        ArrayDeque<Point>q=new ArrayDeque<>();
        q.add(new Point(startX,startY));
        
        while(true){
            
            if(q.isEmpty()){ //q가 비어있을 때
                result.add(cnt);
                break;
            }
            
            Point now = q.pollLast();
            
            if(now.x==endX&&now.y==endY){ //뽑았는 게 같으면
                result.add(cnt);
            }
            
            
            for(int i=0;i<4;i++){
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                
                if(nx==0||ny==0||nx==102||ny==102){
                    continue;
                }
                
                if(maze[ny][nx]){
                    maze[ny][nx]=false; //if문 밑에 넣어줘도 될듯
                    q.add(new Point(nx,ny));
                }
                
            }
            
            cnt++;
            
            
        }
        
        
        
    }
    
}

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}