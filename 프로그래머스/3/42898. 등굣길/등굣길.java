import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int dp[][]=new int[n+1][m+1] ; //1부터 시작
        for(int i=0;i<=m;i++){
            dp[0][i]=Integer.MAX_VALUE;
        }
        
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(dp[i][j]==-1) continue;
                
                if(dp[i-1][j]==-1){
                    dp[i][j]=(dp[i][j-1]+1)%1000000007;
                }
                else if(dp[i][j-1]==-1){
                    dp[i][j]=(dp[i-1][j]+1)%1000000007;
                }
                else{
                    dp[i][j]=(Math.min(dp[i-1][j],dp[i][j-1])+1)%1000000007;
                    }
                
              //if(dp[n-1][m]!=0||dp[n][m-1]!=0){ //또는 그냥 인덱스로 보기
                if(i==n-1&&j==m||i==n&&j==m-1){
                  for(int k=1;k<=n;k++){
            for(int z=1;z<=m;z++){
                System.out.print(dp[k][z]);
            }
            System.out.println();
        }
                  answer=dp[i][j];
                 return answer-1;
              }
        }
        }
        return 0;
        
    }
}
