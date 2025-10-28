import java.util.*;
import java.io.*;

class Solution {
    
    public static int dr[]={-1,0,1,0};
    public static int dc[]={0,1,0,-1};
    
    public int[] solution(String[][] places) {
        int[] answer = {};
        answer=new int[places.length];
        
        for(int i=0;i<places.length;i++){
            int num=bfs(places[i]);
            answer[i]=num;
        }
        
        return answer;
    }
    
    public static int bfs(String[] places) {
        
        char arr[][]=new char[5][5];
        ArrayList<Person>list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++) {
            arr[i]=places[i].toCharArray();
        }
        
        int isVisited[][]=new int[5][5];
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]=='P'){
                    list.add(new Person(i,j));
                }
            }
        }
        
        for(int i=0;i<list.size();i++){
            
            ArrayDeque<Person>q = new ArrayDeque<>();
            q.add(list.get(i));
            isVisited=new int[5][5];
            isVisited[list.get(i).r][list.get(i).c]=1;
            
            while(!q.isEmpty()) {
                
                Person now = q.poll();
                
               
                
                for(int k=0;k<4;k++) {
                    int nr=now.r+dr[k];
                    int nc=now.c+dc[k];
                    
                    if(nr<0||nc<0||nr>=5||nc>=5) continue;
                    
                    if(arr[nr][nc]!='X'&&isVisited[nr][nc]==0){
                        q.add(new Person(nr,nc));
                        isVisited[nr][nc]=isVisited[now.r][now.c]+1;
                        if(isVisited[nr][nc]<=3&&arr[nr][nc]=='P') return 0;
                    }
                }
                
            }

        }
        
        return 1;
        
    }
}

class Person {
    int r;
    int c;
    public Person(int r, int c) {
        this.r=r;
        this.c=c;
    }
}