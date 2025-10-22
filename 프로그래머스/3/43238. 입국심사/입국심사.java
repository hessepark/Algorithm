import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long l=0;
        long r=(long)times[times.length-1]*n;
        long ans=0;
        
        while(l<=r) {
            long m=(l+r)/2;
            
            long sum=0;
            
            for(int i=0;i<times.length;i++) {
                sum+=m/times[i];
                
                if(sum>=n) break;
            }
            
            if(sum>=n){
                ans=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
            
        }
        
        return ans;
        
    }
}