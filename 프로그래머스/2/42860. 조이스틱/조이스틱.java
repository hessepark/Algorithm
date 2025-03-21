import java.util.*;
import java.io.*; 

class Solution {
    public int solution(String name) {
        int answer = 0;
        
         int length=name.length();
        int move = length-1;
       
        
        for(int x=0;x<name.length();x++){
            answer+=Math.min(name.charAt(x)-'A','Z'-name.charAt(x)+1);
            
            int y = x+1;
            while(y<length&&name.charAt(y)=='A'){
                y++;
            }
            
            move=Math.min(move,Math.min(x+x+length-y,length-y+length-y+x));
        }
        answer+=move;
        
        return answer;
    }
}