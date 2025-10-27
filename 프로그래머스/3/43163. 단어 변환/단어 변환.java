import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        q.add(new Word(begin,0));
        
        boolean isVisited[]=new boolean[words.length];
        
        while(!q.isEmpty()) {
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.cnt;
            }
            
            for(int i=0;i<words.length;i++) {
                if(!isVisited[i]&&isPossible(now.word,words[i])){
                    isVisited[i]=true;
                    q.add(new Word(words[i],now.cnt+1));
                }
            }
        }
        
        return answer;
    }
    
    public static boolean isPossible(String a, String b){
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
            if(cnt>=2) return false;
        }
        
        return true;
        
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