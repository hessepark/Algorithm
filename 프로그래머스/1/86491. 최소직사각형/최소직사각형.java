import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        //젤 큰 거랑 
        //작은 거 중에 젤 큰 걸 찾으면 된다.
        int max=Integer.MIN_VALUE; //젤 큰 거
        int minMax=Integer.MIN_VALUE; //작은 거 중에 젤 큰 거 
        
        for(int i=0;i<sizes.length;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<2;j++){
                max=Math.max(max,sizes[i][j]);
                min=Math.min(min,sizes[i][j]);
            }
            minMax=Math.max(minMax,min);
        }
        
        System.out.println(max);
        System.out.println(minMax);
        
        answer=max*minMax;
        
        
        return answer;
    }
}