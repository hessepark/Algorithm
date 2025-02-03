import java.util.*;
import java.io.*;

class Solution {
    public static int ans;
    public int solution(int[] numbers, int target) {
        ans=0;
        
        perm(0,0,numbers,target);
        
        return ans;
    }
    
    public static void perm(int cur,int depth,int[] numbers,int target){
        
        if(depth==numbers.length){
            if(cur==target){
                ans++;
            }
            return;
        }
        
        perm(cur+numbers[depth],depth+1,numbers,target);
        
        perm(cur-numbers[depth],depth+1,numbers,target);
        
    }
}