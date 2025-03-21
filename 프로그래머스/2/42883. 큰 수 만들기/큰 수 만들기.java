import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<number.length();i++){
            while(!q.isEmpty()&&k>0&&number.charAt(i)-'0'>q.peekLast()){
                q.pollLast();
                k--;
            }
            
            //System.out.println(q);
            q.add(number.charAt(i)-'0');
        }
        
        while(k!=0){
            q.pollLast();
            k--;
        }
        
        for(int n:q){
            answer+=n;
        }
        
        
        return answer;
    }
}