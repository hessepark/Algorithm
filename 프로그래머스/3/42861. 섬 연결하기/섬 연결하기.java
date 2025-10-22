import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int[][] costs) {
   
        ArrayList<Integer>list[] = new ArrayList[n];
        
        Arrays.sort(costs,(o1,o2) -> o2[2]-o1[2]);
        
        list=new ArrayList[n];
        
        boolean isVisited[];
        
        int sum=0;
        
        for(int i=0;i<n;i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int cost[]: costs){
            int a=cost[0];
            int b=cost[1];
            sum+=cost[2];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int cost[]:costs) {
            int a=cost[0];
            int b=cost[1];
            int c=cost[2];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            isVisited=new boolean[n];
            
            if(dfs(list,0,isVisited)==n){
                sum-=c;
            }
            else{
                list[a].add(b);
                list[b].add(a);
            }
        }
        
        return sum;
    }
    
    public static int dfs(ArrayList<Integer>list[], int num, boolean[] isVisited) {
        
        int cnt=1;
        
        isVisited[num]=true;
        
        for(int n:list[num]){
            if(!isVisited[n]){
                cnt+=dfs(list,n,isVisited);
            }
        }
        
        return cnt;
        
    }
    
}