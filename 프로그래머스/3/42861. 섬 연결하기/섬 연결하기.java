import java.util.*;
import java.io.*;
class Solution {
    
    public static ArrayList<Integer> list[];
    public static boolean[] isVisited;
    public static int cnt;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (o1,o2)->Integer.compare(o2[2],o1[2]));
        
        list = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<costs.length;i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int v = costs[i][2];
            
            list[a].add(b);
            list[b].add(a);
            answer+=v;
        }
                  
        int except=0;
        
        for(int i=0;i<costs.length;i++){
              
            if(costs.length-except==n-1){
                break;
            }
            
            int a = costs[i][0];
            int b = costs[i][1];
            int v = costs[i][2];
            
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            isVisited=new boolean[n];
            cnt=0;
            
            dfs(0);
            
            //n이 4면 최소 3개는 봐야함
            if(cnt!=n){
                list[a].add(b);
                list[b].add(a);
            }
            else{
                answer-=v;
                except++;
            }
            
            
        }
        
        return answer;
    }
    
    public static void dfs(int num){
        
        isVisited[num]=true;
        cnt++;
        
        for(int child:list[num]){
            if(!isVisited[child]){
                dfs(child);
            }
        }
        
    }
}