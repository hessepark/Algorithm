import java.util.*;
import java.io.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(amount==0){
            return 0;
        }

        int[] isVisited=new int[amount+1];

        ArrayDeque<Integer>q=new ArrayDeque<>();
        q.add(amount);
        
        while(!q.isEmpty()){
            int n=q.poll();
            for(int i=0;i<coins.length;i++){
                if(n-coins[i]>=0&&isVisited[n-coins[i]]==0){
                    isVisited[n-coins[i]]=isVisited[n]+1;
                    
                    if(n-coins[i]==0){
                        return isVisited[n-coins[i]];
                    }
                    q.add(n-coins[i]);
                }
            }
        }

        return -1;

    }
}