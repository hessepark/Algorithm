import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int result=brown+yellow;
        
        int a=-1;
        int b=-1;
        
        for(int i=3;i<=Math.sqrt(result);i++){ //최소 3이상이어야 노란색이 들어갈 공간이 남
            if(result%i==0){
                if((i-2)*(result/i-2)==yellow){ //이 조건 써주지 않으면 테스트케이스 4,6,7 에러남
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