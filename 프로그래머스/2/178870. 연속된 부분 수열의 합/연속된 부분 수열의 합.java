import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int idx[]={0,1000000};
        
        int start=0;
        
        int sum=0;
        for(int end=0;end<sequence.length;end++){
            sum+=sequence[end];
            while(sum>k){
                sum-=sequence[start];
                start++;
            }
            if(sum==k){
                if(idx[1]-idx[0]>end-start){
                    idx[1]=end;
                    idx[0]=start;
                }
            }
        }
        
        answer[0]=idx[0];
        answer[1]=idx[1];
        
        return answer;
    }
}