import java.util.*;
import java.io.*;

class Solution {

    public static int[] dr={-1,0,1,0};
    public static int[] dc={0,1,0,-1};

    public int numIslands(char[][] grid) {
        boolean isVisited[][]=new boolean[grid.length][grid[0].length];

        int cnt=0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++){
                if(!isVisited[i][j]&&grid[i][j]=='1'){
                    bfs(isVisited,grid,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void bfs(boolean[][] isVisited,char[][] grid,int r, int c){

        ArrayDeque<Pos>q=new ArrayDeque<>();
        q.add(new Pos(r,c));
        isVisited[r][c]=true;

        while(!q.isEmpty()){

            Pos pos=q.poll();

            for(int k=0;k<4;k++) {
                int nr=pos.r+dr[k];
                int nc=pos.c+dc[k];
                if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length) continue;

                if(grid[nr][nc]=='1'&&!isVisited[nr][nc]){
                    isVisited[nr][nc]=true;
                    q.add(new Pos(nr,nc));
                }
            }

        }


    }

}

class Pos {
    int r;
    int c;
    public Pos(int r, int c){
        this.r=r;
        this.c=c;
    }
}