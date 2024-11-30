import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int result=brown+yellow;
        
        int a=-1;
        int b=-1;
        
        for(int i=1;i<=Math.sqrt(result);i++){
            if(result%i==0){
                if((i-2)*(result/i-2)==yellow){ //이 조건 써주지 않으면 테스트케이스 4,6,7 에러
                    a=i;
                    b=result/i;
                }
            }
        }
        
        answer[0]=Math.max(a,b);
        answer[1]=Math.min(a,b);
        
        return answer;
    }
}