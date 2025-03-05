import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int dp[][]=new int[triangle.length+1][triangle[triangle.length-1].length+1]; //0,1,2,3,4,5
        
        dp[1][1]=triangle[0][0];
        
        int max = Integer.MIN_VALUE;
        
        for(int i=1;i<=triangle.length;i++){
            for(int j=1;j<=triangle[i-1].length;j++){
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i-1][j-1];
                max=Math.max(max,dp[i][j]);
            }
        }
       
        return max;
    }
}