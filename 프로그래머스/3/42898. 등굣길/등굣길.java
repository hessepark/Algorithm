import java.util.*;
import java.io.*; 

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int dp[][]=new int[n+1][m+1];
        dp[1][1] = 1;
        
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(dp[i][j]==-1) continue;
                
                if(j>1) dp[i][j]=Math.max(dp[i][j],dp[i][j]+dp[i][j-1]);
                if(i>1) dp[i][j]=Math.max(dp[i][j],dp[i][j]+dp[i-1][j]);
                
                dp[i][j]%=1000000007;

            }
        }
        
        // System.out.println(Arrays.toString(dp[1]));
        //   System.out.println(Arrays.toString(dp[2]));
        //   System.out.println(Arrays.toString(dp[3]));
        
        answer=dp[n][m];
        
        return answer;
    }
}