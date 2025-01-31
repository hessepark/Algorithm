import java.util.*;
import java.io.*;

class Solution { // BFS, 넓이를 두 배로 늘린다. 
    
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {-1,0,1,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        boolean[][] line = new boolean[102][102];
        int[][] visited = new int[102][102];
        
        
        //갈 수 있는 길이 true로
        
        for(int [] rect: rectangle) {
            for(int i=rect[1]*2;i<=rect[3]*2;i++){
                for(int j=rect[0]*2;j<=rect[2]*2;j++){
                    line[i][j] = true;
                }
            }
        }
        
        for(int [] rect: rectangle) { //안 쪽 다 false 처리 (테두리만 남김) 여기다 +1 안 해줘서 문제였음
            for(int i=rect[1]*2+1;i<rect[3]*2;i++){
                for(int j=rect[0]*2+1;j<rect[2]*2;j++){
                    line[i][j] = false;
                }
            }
        }
        
        int cx=characterX*2;
        int cy=characterY*2;
        
        int ix=itemX*2;
        int iy=itemY*2;
        
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(new Point(cy,cx));
        visited[cy][cx]=1;
        
        while(!q.isEmpty()){
            Point now = q.poll();
            
            for(int i=0;i<4;i++){
                int nx= dx[i]+now.x;
                int ny= dy[i]+now.y;
                
                if(nx==0||ny==0||nx==102||ny==102||visited[ny][nx]!=0||line[ny][nx]==false){
                    continue;
                }
                
                visited[ny][nx]=visited[now.y][now.x]+1;
                q.add(new Point(ny,nx));
            }
        }
        
//         for(int i=0;i<102;i++){
//             for(int j=0;j<102;j++){
//                 if(line[i][j]){
//                     System.out.print("T");
//                 }
//                 else{
//                     System.out.print("F");
//                 }
                
//             }
//             System.out.println();
//         }
        
        answer=visited[iy][ix]/2;
        
        return answer;
    }
}

class Point {
    int y;
    int x;
    public Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}