import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[words.length];
        q.add(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            
            if(word.word.equals(target)){
                return word.cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(!isVisited[i]&&isPossible(words[i],word.word)){
                    q.add(new Word(words[i],word.cnt+1));
                    //System.out.println(words[i]+" "+(word.cnt+1));
                    isVisited[i]=true;
                }
            }
            
        }
        
        return answer;
    }
    
    public static boolean isPossible(String a,String b){
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
            if(cnt>1) return false;
        }
        
        return true;
    }
}

class Word {
    String word;
    int cnt;
    
    public Word(String word, int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}