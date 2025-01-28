import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character>q = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                q.add(s.charAt(i));
            }
            else{
                if(q.isEmpty()){
                    return false; //바로 )부터 들어오면
                }
                q.poll();
            }
        }
        
        if(!q.isEmpty()){
            answer = false;
        }

        return answer;
    }
}