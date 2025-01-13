import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max = Integer.MIN_VALUE; //젤 큰 거
        int minMax = Integer.MIN_VALUE; //작은 거 중에 젤 큰 거
        
        for(int i=0;i<sizes.length;i++){
            for(int j=1;j<sizes[0].length;j++){
               max=Math.max(max,Math.max(sizes[i][0],sizes[i][1]));
               minMax=Math.max(minMax,Math.min(sizes[i][0],sizes[i][1]));
            }
        }
        
        answer = max * minMax;
        
        return answer;
    }
}