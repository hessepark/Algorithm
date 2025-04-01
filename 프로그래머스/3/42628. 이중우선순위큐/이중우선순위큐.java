import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer>minQ = new PriorityQueue<>();
        PriorityQueue<Integer>maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
       
        
        for(int i=0;i<operations.length;i++){
             String oper[]= operations[i].split(" ");
            String alpha=oper[0];
            int num =Integer.parseInt(oper[1]);
            
            if(alpha.equals("I")){
                minQ.add(num);
                maxQ.add(num);
            }
            else{
                
                if(minQ.isEmpty()){
                    continue;
                }
                
                if(num<0){
                int n=minQ.poll();
                maxQ.remove(n);
                }
                else{
                    int n=maxQ.poll();
                    minQ.remove(n);
                }
            }
            
             // System.out.println(minQ);
             // System.out.println(maxQ);
        }
        
        if(!minQ.isEmpty()){
            answer[0]=maxQ.poll();
            answer[1]=minQ.poll();
        }
        
        return answer;
    }
}