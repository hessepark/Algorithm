import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer> list[];
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs,(o1,o2)->o2[2]-o1[2]);
        
//         for(int i=0;i<costs.length;i++){
//             System.out.println(costs[i][2]);
//         }
        
        //제외 대상
        //int except[]=new int[costs.length];
        isVisited=new boolean[n];
        list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<costs.length;i++){
            int a=costs[i][0];
            int b=costs[i][1];
            
            list[a].add(b);
            list[b].add(a);
            
            answer+=costs[i][2];
        }
        
        for(int i=0;i<costs.length;i++){
            
            int a=costs[i][0];
            int b=costs[i][1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            isVisited=new boolean[n];
            
            int cnt=dfs(0);
            
            //System.out.println(cnt);
            
            if(cnt==n){
                answer-=costs[i][2];
            }
            
            else{
                list[a].add(b);
                list[b].add(a);
            }
            
        
            
        }
        
        return answer;
    }
    
    public static int dfs(int n){
        
        isVisited[n]=true;
        
        int cnt=1;
        
        for(int child:list[n]){
            if(!isVisited[child]){
               cnt+=dfs(child);
            }
        }
        
        return cnt;
        
    }
}