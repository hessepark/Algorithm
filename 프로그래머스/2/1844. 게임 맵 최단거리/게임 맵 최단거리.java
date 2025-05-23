import java.util.*;
import java.io.*;
class Solution {
    
    public static int dr[]={-1,0,1,0};
    public static int dc[]={0,1,0,-1};
    
    public static int visited[][];
    
    public int solution(int[][] maps) {
        
        visited=new int[maps.length][maps[0].length];
        visited[0][0]=1;
        
        ArrayDeque<Pos>q = new ArrayDeque<>();
        q.add(new Pos(0,0));
        
        while(!q.isEmpty()){
            
            Pos now = q.poll();
            
            if(now.r==maps.length-1&&now.c==maps[0].length-1){
                return visited[now.r][now.c];
            }
            
            for(int i=0;i<4;i++){
                int nr = now.r+dr[i];
                int nc = now.c+dc[i];
                    
                if(nr==-1||nc==-1||nr==maps.length||nc==maps[0].length){
                    continue;
                }
                
                if(maps[nr][nc]==1&&visited[nr][nc]==0){
                    q.add(new Pos(nr,nc));
                    visited[nr][nc]=visited[now.r][now.c]+1;
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