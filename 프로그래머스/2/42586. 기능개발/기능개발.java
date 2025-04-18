import java.util.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<progresses.length;i++){
            
            int val= (100-progresses[i])/speeds[i];
            
            if((100-progresses[i])%speeds[i]==0){
                q.add(val);
            }
            else{
                q.add(val+1);
            }
            
        }
        
        //System.out.println(q);
        
        ArrayList<Integer>result = new ArrayList<>();
        
        while(!q.isEmpty()){
            int cnt=1;
            int num = q.poll();
            
            while(!q.isEmpty()&&num>=q.peekFirst()){
                q.poll();
                cnt++;
            }
            
            result.add(cnt);
            
        }
        
        answer =new int[result.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}