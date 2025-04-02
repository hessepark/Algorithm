import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes,(o1,o2)->{return Integer.compare(o1[1],o2[1]);});
        
        int camera=routes[0][1];
        answer++;
        
        for(int i=1;i<routes.length;i++){
            if(camera<routes[i][0]){
                camera=routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}