import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String[] answer = new String[numbers.length];
        
        //문자를 붙여서 비교해야함
        for(int i=0;i<numbers.length;i++){
            answer[i]=numbers[i]+"";
        }
        
        Arrays.sort(answer,(o1,o2)-> (o2+o1).compareTo(o1+o2));
        
        if(answer[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<answer.length;i++){
            sb.append(answer[i]);
        }
        
        return sb.toString();
    }
}