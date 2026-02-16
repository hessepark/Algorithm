import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character>q = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='('){
                q.addLast(')');
            }
            else{
                if(q.isEmpty()){
                    return false;
                }
                else q.pollLast();
            }
        }

        return q.isEmpty();
    }
}