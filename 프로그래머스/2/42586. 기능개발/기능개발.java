import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        ArrayList<Integer>result = new ArrayList<>();
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }
            else{
                q.add((100-progresses[i])/speeds[i]+1);
            }
        }
        
        //System.out.println(q);
        
        while(!q.isEmpty()){
            int count=1;
            int num=q.poll();
            while(!q.isEmpty()){
                if(num>=q.peekFirst()){
                    q.poll();
                    count++;
                }
                else{
                    break;
                }
            }
            result.add(count);
        }
        
        //System.out.println(result);
        
        answer=new int[result.size()];
        
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        
        return answer;
    }
}