import java.util.*;
import java.io.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int move=name.length()-1;
        
        for(int i=0;i<name.length();i++) {
            
            answer+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            
            int x=i;
            int y=x+1;
            
            while(y<name.length()&&name.charAt(y)=='A'){
                y++;
            }
            
            move=Math.min(move,Math.min(2*x+name.length()-y,(name.length()-y)*2+x));
            
        }
        
        answer+=move;
        
        return answer;
    }
}