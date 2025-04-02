import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes,(o1,o2)->Integer.compare(o1[0],o2[0]));
        
        boolean isVisited[]=new boolean[routes.length];
        
        for(int i=0;i<routes.length;i++){
            
            if(isVisited[i]){
                continue;
            }
            
            isVisited[i]=true;
            
            int start=routes[i][0];
            int end=routes[i][1];
            
            //같이 찍을 수 있으면 true로 만들기
            
            for(int j=i+1;j<routes.length;j++) {
                
                if(end<routes[j][0]){
                    break;
                }
                
                start=Math.max(start,routes[j][0]);
                end=Math.min(end,routes[j][1]);
                
                isVisited[j]=true;
                
            }
            
            
            answer++;
            
        }
        
        return answer;
    }
}