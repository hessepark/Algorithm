import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        //작업 일수 담음
        ArrayDeque<Integer>list = new ArrayDeque<>();
        
        for(int i=0;i<progresses.length;i++){
            int num = (100-progresses[i]);
            
            if(num%speeds[i]==0){
                list.add(num/speeds[i]);
            }
            else{
                list.add(num/speeds[i]+1);
            }
            
        }
        
        //System.out.println(list);
        
        
        //빼내는 수 담음
        
        ArrayList<Integer>result = new ArrayList<>();
        
        while(!list.isEmpty()){
            int num = list.pollFirst();
            
            int cnt=1;
            
         
              while(!list.isEmpty()&&list.peekFirst()<=num){
                if(!list.isEmpty()){
                    cnt++;
                    list.pollFirst();
                }
            }
            result.add(cnt);
        }
        
        answer=new int[result.size()];
        
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        
        
        return answer;
    }
}