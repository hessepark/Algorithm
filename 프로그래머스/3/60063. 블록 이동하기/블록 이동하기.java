import java.util.*;
import java.io.*;
class Solution {
    public static int[] dr= {-1,0,1,0};
    public static int[] dc= {0,1,0,-1};
    public static int n,m;
    
    //p1을 기준으로 수직 수평 방문 여부 검사.
    
    //탐색
    //1. 4방향 탐색
    //2. 수직->수평
    //3. 수평->수직
    public int solution(int[][] board) {
        int answer = 0;
        
        n =board.length;
        m =board[0].length;
        int[][][] visited = new int[n+1][m+1][2]; //수직 수평 방문여부 따로 검사 p1 기준
        //0수평 1 수직
        
        ArrayDeque<Robot>q = new ArrayDeque<>(); 
        q.add(new Robot(new Point(1,1),new Point(1,2),0));
        visited[1][1][0]=1;
        
        while(!q.isEmpty()){
            
            Robot now = q.poll();
            Point p1 = now.p1;
            Point p2 = now.p2;
            
            if((p1.r==n&&p1.c==m)||(p2.r==n&&p2.c==m)){ //도착
                return visited[p1.r][p1.c][now.vertical]-1;
            }
            
            int curTime = visited[p1.r][p1.c][now.vertical]; //현재 시간
            
            //4방향 탐색
            for(int k=0;k<4;k++){
                int nr1= p1.r+dr[k], nc1=p1.c+dc[k];
                int nr2= p2.r+dr[k], nc2=p2.c+dc[k];
                
                if(isValid(nr1,nc1)&&isValid(nr2,nc2)&&board[nr1-1][nc1-1]==0&&board[nr2-1][nc2-1]==0){ // 다 0이어야됨
                    
                    Robot moved = new Robot(new Point(nr1,nc1),new Point(nr2,nc2),now.vertical);
                    Point base = moved.p1;
                    if(visited[base.r][base.c][moved.vertical]==0){ //안 가본곳이어야함.
                        visited[base.r][base.c][moved.vertical]= curTime+1;
                        q.add(moved);
                    }
                    
                }
            }
            
            //수평->수직
            if(p1.r==p2.r){
                for(int d:new int[]{-1,1}){
                    if(isValid(p1.r+d,p1.c)&&isValid(p2.r+d,p2.c)&&board[p1.r+d-1][p1.c-1]==0&&board[p2.r+d-1][p2.c-1]==0){
                        Robot r1 = new Robot(p1,new Point(p1.r+d,p1.c),1);
                        Robot r2 = new Robot(p2,new Point(p2.r+d,p2.c),1);
                        
                        if(visited[r1.p1.r][r1.p1.c][1]==0){
                            visited[r1.p1.r][r1.p1.c][1]=curTime+1;
                            q.add(r1);
                        }
                        if(visited[r2.p1.r][r2.p1.c][1]==0){
                            visited[r2.p1.r][r2.p1.c][1]=curTime+1;
                            q.add(r2);
                        }
                        
                    }
                    
                }
            }
            else{ //수직->수평
                for(int d:new int[]{-1,1}){
                    if(isValid(p1.r,p1.c+d)&&isValid(p2.r,p2.c+d)&&board[p1.r-1][p1.c+d-1]==0&&board[p2.r-1][p2.c+d-1]==0){
                        
                        Robot r1 = new Robot(p1,new Point(p1.r,p1.c+d),0);
                        Robot r2 = new Robot(p2,new Point(p2.r,p2.c+d),0);
                        
                        if(visited[r1.p1.r][r1.p1.c][0]==0){
                            visited[r1.p1.r][r1.p1.c][0]=curTime+1;
                            q.add(r1);
                        }
                        if(visited[r2.p1.r][r2.p1.c][0]==0){
                            visited[r2.p1.r][r2.p1.c][0]=curTime+1;
                            q.add(r2);
                        }
                        
                    }
                }
            }
            
        }
        
        return -1;
    }
    
    public static boolean isValid(int r,int c){
        return r>0&&c>0&&r<=n&&c<=m;
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

class Robot {
    Point p1;
    Point p2;
    int vertical;
    
    public Robot(Point p1,Point p2,int vertical){
        if(p1.r<p2.r||(p1.r==p2.r&&p1.c<p2.c)){
           this.p1=p1;
           this.p2=p2;
        } else {
            this.p1=p2;
            this.p2=p1;
        }
        this.vertical=vertical;
    }
}