import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //무조건 가로 길이가 3이상이어야지 노란색이 하나가 나옴
        
        int count = brown+yellow;
        
        for(int i=3;i<count;i++){
            if(count%i==0){
                //System.out.println(i);
                if((i-2)*(count/i-2)==yellow){
                   answer[0]=i;
                   answer[1]=count/i;
                }
                
                
            }
        }
        
        return answer;
    }
}