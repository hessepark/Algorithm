import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int l=1;l<=s.length()/2;l++){
        
             ArrayList<String> words = new ArrayList<>();
                
            for(int i=0;i<s.length();i+=l) {
                     words.add(s.substring(i,Math.min(s.length(),i+l)));
                }
            
            ArrayDeque<Entry>q = new ArrayDeque<>();
            
            q.add(new Entry(words.get(0),1));
            
            for(int i=1;i<words.size();i++){
                if(q.peekLast().word.equals(words.get(i))){
                    Entry entry = q.pollLast();
                    q.add(new Entry(entry.word,entry.count+1));
                }
                else{
                    q.add(new Entry(words.get(i),1));
                }
            }
            
            StringBuilder compressed = new StringBuilder();
            
            while(!q.isEmpty()){
                Entry entry = q.pollLast();
                if(entry.count>1){
                    compressed.append(String.valueOf(entry.count));
                }
                compressed.append(entry.word);
            }

            answer=Math.min(answer,compressed.toString().length());
            
            
            }
        
        return answer;
    }
    
    
}

class Entry {
    String word;
    int count;
    
    public Entry(String word, int count){
        this.word=word;
        this.count=count;
    }
}