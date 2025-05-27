import java.util.*;
import java.io.*;
class Solution {
    
    public static boolean isVisited[];
    
    public int solution(String begin, String target, String[] words) {
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        q.add(new Word(begin,0));
        isVisited=new boolean[words.length];
        
        while(!q.isEmpty()){
            
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(!isVisited[i]&&isCount(now.word,words[i])==1){
                    isVisited[i]=true;
                    q.add(new Word(words[i],now.cnt+1));
                }
            }
            
        }
        
        return 0;
    }
    
    public static int isCount(String a,String b){
        
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        
        return cnt;
        
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