import java.util.*;
import java.io.*;

class Solution {
    
    public static ArrayList<Integer> list[];
    public static boolean isVisited[];
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        list = new ArrayList[n];
        isVisited = new boolean[n];
        
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        
        Arrays.sort(costs,((o1,o2)->Integer.compare(o2[2],o1[2])));
        
        for(int i=0;i<costs.length;i++){
            
            answer+=costs[i][2];
            
            int a = costs[i][0];
            int b = costs[i][1];
            
            list[a].add(b);
            list[b].add(a); 
        }
        
        int cnt=0;
        
        for (int i=0;i<costs.length;i++){
            
            if(costs.length-cnt==n-1){
                break;
            }
                 
            int a = costs[i][0];
            int b = costs[i][1];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            isVisited=new boolean[n];
            
            int connect=dfs(0);
            
            if(connect!=n){
                list[a].add(b);
                list[b].add(a);
            }
            else{
                answer-=costs[i][2];
                cnt++;
            }
            
        }
        
        
        return answer;
    }
    
    public static int dfs(int n){
        
        int cnt=1;
        isVisited[n] = true;
        
        for(int child:list[n]){
            if(!isVisited[child]){
                cnt+=dfs(child);
            }
        }
        
        return cnt;
        
        
    }
}