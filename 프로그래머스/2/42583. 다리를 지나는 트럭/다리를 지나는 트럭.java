import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        int total_weight=0;
        int time=0;
        
        for(int i=0; i<truck_weights.length;i++){
            
            while(true){
                
            if(q.size()<bridge_length){
                if(total_weight+truck_weights[i]<=weight){
                    q.add(truck_weights[i]);
                    total_weight+=truck_weights[i];
                    time++;
                    break;
                }
                
                else{
                    q.add(0);
                    time++;
                }
             }
                
                if(q.size()==bridge_length){
                    total_weight-=q.peekFirst();
                    q.poll();
                }
                
                
            }
            
        }
        
        time+=bridge_length;
        
        return time;
    }
}