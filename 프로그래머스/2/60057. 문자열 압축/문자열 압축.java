import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int l=1;l<=s.length()/2;l++){
            
            ArrayList<String>word = new ArrayList<>();
            
            for(int i=0;i<s.length();i+=l){
                word.add(s.substring(i,Math.min(s.length(),i+l)));
            }
            
            ArrayDeque<Word>q = new ArrayDeque<>();
            q.add(new Word(word.get(0),1));
            
            for(int i=1;i<word.size();i++){
                
                if(q.peekLast().word.equals(word.get(i))){
                    Word now = q.pollLast();
                    q.add(new Word(now.word,now.cnt+1));
                }
                else{
                    q.add(new Word(word.get(i),1));
                }
                
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(Word alpha: q){
                sb.append(alpha.word);
                if(alpha.cnt>=2){
                    sb.append(alpha.cnt);
                }
            }
            
            answer=Math.min(answer,sb.toString().length());
            
        }
        
        
        return answer;
    }
}

class Word {
    String word;
    int cnt;
    public Word(String word,int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}