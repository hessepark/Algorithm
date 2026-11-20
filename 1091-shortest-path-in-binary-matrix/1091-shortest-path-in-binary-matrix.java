import java.util.*;
import java.io.*;

class Solution {

    public static int dr[]={-1,-1,0,1,1,1,0,-1};
    public static int dc[]={0,1,1,1,0,-1,-1,-1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int [][]isVisited=new int[grid.length][grid[0].length];
        isVisited[0][0]=1;

        if(grid[0][0]==1) return -1;

        ArrayDeque<Pos>q=new ArrayDeque<>();
        q.add(new Pos(0,0));

        while(!q.isEmpty()) {

            Pos now = q.poll();

            if(now.r==grid.length-1&&now.c==grid[0].length-1){
                return isVisited[now.r][now.c];
            }

            for(int d=0;d<8;d++){
                int nr=now.r+dr[d];
                int nc=now.c+dc[d];

                if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length) continue;

                if(grid[nr][nc]==0&&isVisited[nr][nc]==0){
                    isVisited[nr][nc]=isVisited[now.r][now.c]+1;
                    q.add(new Pos(nr,nc));
                }
            }

        }

        return -1;

    }
}

class Pos {
    int r;
    int c;
    public Pos(int r,int c){
        this.r=r;
        this.c=c;
    }
}