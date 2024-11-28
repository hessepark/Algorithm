import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        ArrayDeque<Integer>q = new ArrayDeque<>(); //다리 위 트럭들 큐
        int present_sum=0; //현재 다리 위 트럭들 무게
        int time=0; //걸리는 시간 변수
        
        for(int i=0;i<truck_weights.length;i++) {
            int truck=truck_weights[i];
            
            while(true){
            
            if(q.size()==bridge_length){
                present_sum-=q.poll();
                //System.out.println(q);
            }
                time++;
            if(present_sum+truck<=weight){
                q.add(truck);
                present_sum+=truck;
                //System.out.println(q);
                break;
            }
            else{
                q.add(0);
                //System.out.println(q);
            }
            
            }
        }
        
        //System.out.println(q);
        
        time+=bridge_length;
        
        answer=time;
        
        return answer;
    }
}