import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max=Integer.MIN_VALUE;
        int minMax=Integer.MIN_VALUE;
        
        for(int i=0;i<sizes.length;i++) {
            max=Math.max(max,Math.max(sizes[i][0],sizes[i][1]));
            minMax=Math.max(minMax,Math.min(sizes[i][0],sizes[i][1]));
        }
        
        answer=max*minMax;
        
        return answer;
    }
}