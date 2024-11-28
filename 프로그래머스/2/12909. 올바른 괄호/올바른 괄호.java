import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character>q = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='('){ // (가 들어올 때와 )가 들어올 때를 구분
                q.add(s.charAt(i));
            }
            else {
                if(q.isEmpty()){
                    return false;
                }
                else{
                    q.poll();
                }
            }
        }
        
        if(!q.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}