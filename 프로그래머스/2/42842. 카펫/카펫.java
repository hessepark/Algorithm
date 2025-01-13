import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i=3;i<=Math.sqrt(sum);i++){
            if(sum%i==0){
                //System.out.println(i);
               if((i-2)*((sum/i)-2)==yellow){
                   answer[0]=sum/i;
                   answer[1]=i;
               }
            }
        }
        
        return answer;
    }
}