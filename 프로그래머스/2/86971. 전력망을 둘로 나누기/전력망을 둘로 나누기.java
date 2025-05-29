import java.util.*;
import java.io.*;
class Solution {
    
    public static int n;
    public static int minDiff;
    public static boolean[] isVisited;
    public static ArrayList<Integer>list[];
    public int solution(int n, int[][] wires) {
       
        this.n=n;
        minDiff=Integer.MAX_VALUE;
        isVisited=new boolean[n+1];
        list=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<wires.length;i++){
            int a=wires[i][0];
            int b=wires[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        dfs(1);
        
        return minDiff;
    }
    
    public static int dfs(int num){
        
        isVisited[num]=true;
        
        int count=1;
        
        for(int child:list[num]){
            if(!isVisited[child]){
                count+=dfs(child);
            }
        }
        
        minDiff=Math.min(minDiff,Math.abs(n-count*2));
        
        return count;
        
        
    }
}