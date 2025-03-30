import java.util.*;
import java.io.*;

//둘 다 추가하면 둘 다 비어있는 게 아니면 무조건 값이 있다. (단순히 오름차순 내림차순인 것만 다름)
//PriorityQueue에서 값 지목해서 뺄 수 있다.

class Solution {
    public int[] solution(String[] operations) {
        int[] answer =new int[2];
        
        PriorityQueue<Integer>minQ = new PriorityQueue<>();
        PriorityQueue<Integer>maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<operations.length;i++){
            String str[] = operations[i].split(" ");
            
            String alpha=str[0];
            int num = Integer.parseInt(str[1]);
            
            if(alpha.equals("I")){
                minQ.add(num);
                maxQ.add(num);
            }
            else if(alpha.equals("D")){
                
                if(minQ.isEmpty()){
                    continue;
                }
                
                if(num==1){
                    int n = maxQ.poll();
                    minQ.remove(n);
                }
                else if(num==-1){
                    int n = minQ.poll();
                    maxQ.remove(n);
                }
                
            }    
        }
        
        if(!maxQ.isEmpty()&&!minQ.isEmpty()){
            answer[0]=maxQ.poll();
            answer[1]=minQ.poll();
        }
        
        return answer;
    }
}