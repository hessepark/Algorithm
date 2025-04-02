import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<number.length();i++){
            
            if(q.isEmpty()){
                q.add(number.charAt(i)-'0');
                System.out.println(q); 
                continue;
            }
            
            
            while(!q.isEmpty()&&q.peekLast()<number.charAt(i)-'0'){
                    if(k-1>=0){
                        q.pollLast();
                        k--;
                      }
                    else{
                        break;
                    }
            }
            
            q.add(number.charAt(i)-'0');
            
            //System.out.println(q);         
        }
        
        while(k-->0){
            q.pollLast();
        }
        
        while(!q.isEmpty()){
            answer+=q.poll();
        }
        
        return answer;
    }
}