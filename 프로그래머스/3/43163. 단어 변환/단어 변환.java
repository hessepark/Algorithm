import java.util.*;
import java.io.*;
class Solution {
    
    public static boolean isVisited[];
    
    public int solution(String begin, String target, String[] words) {
        
        isVisited=new boolean[words.length];
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        q.add(new Word(begin,0));
        
        while(!q.isEmpty()){
            
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(!isVisited[i]&&isCount(words[i],now.word)==1){
                    q.add(new Word(words[i],now.cnt+1));
                    isVisited[i]=true;
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

class Word{
    String word;
    int cnt;
    public Word(String word,int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}