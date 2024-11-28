import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }
            else{
                q.add((100-progresses[i])/speeds[i]+1);
            }
        }
        
        ArrayList<Integer>list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int num=q.poll();
            int cnt=1;
            
            while(!q.isEmpty()&&num>=q.peekFirst()){
                q.poll();
                cnt++;
            }
            
            list.add(cnt);
            
        }
        
        //System.out.println(list);
        
        answer = new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        
        
        return answer;
    }
}