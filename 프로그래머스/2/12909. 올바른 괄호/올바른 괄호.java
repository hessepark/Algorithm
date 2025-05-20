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
                    return false;
                }
                else{
                    q.pollLast();
                }
            }    
            
        }
        
        if(!q.isEmpty()){
            return false;
        }
        
        return true;

    }
}