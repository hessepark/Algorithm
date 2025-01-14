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
            
            int cnt = dfs(1,n);
            
            //System.out.println(cnt);
            min=Math.min(min,Math.abs((n-cnt)-cnt));
            
            //붙이기
            list[a].add(b);
            list[b].add(a);   
            
        }
        
         
        
        return min;
        
    }
    
    public int dfs(int num,int n){
        
        int cnt=1;
        
        isVisited[num]=true;
        
         for(int child:list[num]){
             if(!isVisited[child]){
                 cnt+=dfs(child,n);
             }
         }        
        
        return cnt;
    }
}