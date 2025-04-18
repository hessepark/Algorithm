import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<String>q= new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                q.add("(");
            }
            else {
                if(q.isEmpty()){
                    return false;
                }
                q.poll();
            }
        }
        
        if(!q.isEmpty()){
            answer=false;
        }

        return answer;
    }
}