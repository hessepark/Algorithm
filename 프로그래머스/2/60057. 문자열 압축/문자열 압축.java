import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=1;i<=s.length()/2;i++){
            answer=Math.min(answer,zip(s,i));
        }
        
        if(s.length()==1){
            return 1;
        }
        
        return answer;
    }
    
    public static int zip(String s, int l) {
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i+=l) {
            String alpha=s.substring(i,Math.min(i+l,s.length()));
            
            if(q.isEmpty()){
                q.addLast(new Word(alpha,1));
            }
            else{
                if(q.peekLast().word.equals(alpha)){
                    Word now=q.pollLast();
                    q.addLast(new Word(now.word, now.cnt+1)); //alpha해도 됨
                }
                else{
                    q.addLast(new Word(alpha,1));
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()){
            Word now = q.pollLast();
            if(now.cnt>=2){
                sb.append(now.cnt);
            }
            sb.append(now.word);
        }
        
        return sb.toString().length();
        
    }
    
}

class Word {
    String word;
    int cnt;
    
    public Word(String word, int cnt) {
        this.word=word;
        this.cnt=cnt;
    }
}