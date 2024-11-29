import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int p[][] = { {1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        
        int cnt[]=new int[3];
        
        int max=Integer.MIN_VALUE;
       
        for(int i=0;i<3;i++){
            int num=0;
            for(int j=0;j<answers.length;j++){
                if(answers[j]==p[i][j%p[i].length]){
                    num++;
                }
            }
            cnt[i]=num;
            max=Math.max(max,cnt[i]);
        }
        
        ArrayList<Integer>list = new ArrayList<>();
        
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==max){
                list.add(i+1);
            }
        }
        
        answer=new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        
        
        

        
        
    //System.out.println(Arrays.toString(cnt));
        
        
        
        return answer;
    }
}