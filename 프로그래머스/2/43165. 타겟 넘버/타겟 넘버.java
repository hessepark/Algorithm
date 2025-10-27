import java.util.*;
import java.io.*;

class Solution {
    public static int cnt;
    public int solution(int[] numbers, int target) {
        cnt=0;
        
        dfs(0,0,numbers,target);
        
        return cnt;
    
    }
    
    public static void dfs(int num, int depth, int[] numbers, int target) {
        
        if(depth==numbers.length){
            
            if(num==target){
                cnt++;
            }
            
            return;
            
        }
        
        dfs(num+numbers[depth],depth+1,numbers,target);
        dfs(num-numbers[depth],depth+1,numbers,target);
        
    }
}