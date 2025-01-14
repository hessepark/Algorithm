import java.io.*;
import java.util.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer>list[];
    public static int min; //절댓값 차이가 최소인 거
    
    public int solution(int n, int[][] wires) {
        
        min = Integer.MAX_VALUE;
        
        list = new ArrayList[n+1];
        
        for(int i=1; i< n+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            //하나 끊고
            
            isVisited=new boolean[n+1];
            
            //bfs or dfs
            
            int cnt = bfs(1,n);
            
            
            //붙이기
            list[a].add(b);
            list[b].add(a);   
            
            
            min=Math.min(min,Math.abs((n-cnt)-cnt));
        }
        
         
        
        return min;
        
    }
    
    public int bfs(int num,int n){
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        q.add(num);
        isVisited[num]=true;
        int cnt=0;
        
        while(!q.isEmpty()){
            
            int now = q.poll();
            cnt++;
            
            for(int child:list[now]){
                if(!isVisited[child]){
                    q.add(child);
                    isVisited[child]=true;
                }
            }   
        }
        //System.out.println(cnt);
        return cnt;
       
        
    }
}