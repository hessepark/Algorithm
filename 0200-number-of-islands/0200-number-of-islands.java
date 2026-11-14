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
                    dfs(isVisited,grid,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(boolean[][] isVisited,char[][] grid,int r, int c){

        isVisited[r][c]=true;

            for(int k=0;k<4;k++) {
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr<0||nc<0||nr>=grid.length||nc>=grid[0].length) continue;

                if(grid[nr][nc]=='1'&&!isVisited[nr][nc]){
                    dfs(isVisited,grid,nr,nc);
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