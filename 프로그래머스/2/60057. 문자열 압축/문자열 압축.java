import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=s.length()/2;i++){
            answer = Math.min(answer,compress(s,i));
        }
        
        return answer;
    }
    
    public int compress(String s,int length) {
        
        ArrayList<String> words = new ArrayList<>();
        for(int i=0;i<s.length();i+=length){
            words.add(s.substring(i,Math.min(s.length(),i+length)));
        }
        StringBuilder sb = new StringBuilder();
        int count=0;
        String prev="";
        
        for(String word: words) {
            if(word.equals(prev)){
                count++;
            }
            else{
                
                if(count>1){
                    sb.append(String.valueOf(count));
                }
                sb.append(prev);
                
                prev=word;
                
                count=1;
            }
        }
        
        if(count>1){
                    sb.append(String.valueOf(count));
                }
        sb.append(prev);
        
        return sb.toString().length();
        
    }
}