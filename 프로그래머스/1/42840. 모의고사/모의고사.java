import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int solve [][] = { {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int cnt [] = new int[3];
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<solve.length;i++){
                for(int j=0;j<answers.length;j++){
                    if(answers[j]==solve[i][j%solve[i].length]){
                        cnt[i]++;
                        max = Math.max(cnt[i],max);
                    }
                }
        }
        
        ArrayList<Integer>result = new ArrayList<>();
        
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==max){
                result.add(i+1);
            }
        }
        
        answer = new int[result.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}