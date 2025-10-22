import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long l=0;
        long r=(long)n*1000000000;
        long ans=-1;
        
        while(l<=r) {
            long mid=(l+r)/2;
            
            if(caculate(mid,times)>=n){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        
        return ans;   
    }
    
    public static long caculate(long mid, int[] times) {
        long sum=0;
        
        for(int time:times){
            sum+=mid/time;
        }
        
        return sum;
    }
}