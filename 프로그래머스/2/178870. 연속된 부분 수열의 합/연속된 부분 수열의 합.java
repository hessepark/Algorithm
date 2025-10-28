import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,Integer.MAX_VALUE};
        
        int rightIndex=0;
        int sum=0;
        for(int i=0;i<sequence.length;i++) {
            while(sum<k&&rightIndex<sequence.length){
                sum+=sequence[rightIndex++];
            }
            
            if(sum==k&&answer[1]-answer[0]>rightIndex-1-i){
                answer[0]=i;
                answer[1]=rightIndex-1;
            }
            sum-=sequence[i];
        }
        
        return answer;
    }
}