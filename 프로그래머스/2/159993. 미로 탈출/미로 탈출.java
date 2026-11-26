import java.util.*;
import java.io.*;

class Solution {
    
    public static int st[];
    public static int ed[];
    public static int lv[];
    public static int dr[]={-1,0,1,0};
    public static int dc[]={0,1,0,-1};
    public static int isVisited[][];
    
    public int solution(String[] maps) {
        
        st=new int[2];
        ed=new int[2];
        lv=new int[2];
        isVisited=new int[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            char tmp[]=maps[i].toCharArray();
            for(int j=0;j<tmp.length;j++){
                if(tmp[j]=='S'){
                    st[0]=i;
                    st[1]=j;
                }
                if(tmp[j]=='E'){
                    ed[0]=i;
                    ed[1]=j;
                }
                if(tmp[j]=='L'){
                    lv[0]=i;
                    lv[1]=j;
                }
            }
        }
        
        int sToLv=bfs(st,lv,maps);
        
       // System.out.println("거점: "+sToLv);
            
        isVisited=new int[maps.length][maps[0].length()];
        
        int lToE=bfs(lv,ed,maps);
        
        if(sToLv<0||lToE<0){
            return -1;
        }
        
        //System.out.println("종착: "+lToE);
    
        
        return sToLv+lToE;
    }
    
    public static int bfs(int s[],int e[],String[] maps) {
        
        ArrayDeque<Pos>q=new ArrayDeque<>();
        isVisited[s[0]][s[1]]=1;
        q.add(new Pos(s[0],s[1]));
        
        while(!q.isEmpty()) {
            
            Pos now=q.poll();
            
            if(now.r==e[0]&&now.c==e[1]){
                return isVisited[now.r][now.c]-1;
            }
            
            for(int d=0;d<4;d++) {
                int nr=now.r+dr[d];
                int nc=now.c+dc[d];
                
                if(nr<0||nc<0||nr>=maps.length||nc>=maps[0].length()){
                    continue;
                }
                
                if(isVisited[nr][nc]==0&&maps[nr].charAt(nc)!='X'){
                    isVisited[nr][nc]=isVisited[now.r][now.c]+1;
                    q.add(new Pos(nr,nc));
                    //System.out.println(nr+" "+nc);
                }
            }
            
        }
        
        return -1;
        
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