import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayDeque<Word>q;
    public static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        
        isVisited = new boolean[words.length];
        q = new ArrayDeque<>();
        q.add(new Word(begin,0));
        
        bfs(begin,target,words);
        
        return answer;
    }
    
    public static void bfs(String cur, String target, String[] words){
               
        while(!q.isEmpty()){
        
            Word now = q.poll();
            
            if(now.word.equals(target)){
                answer=now.cnt;
                return;
            }
            
            for(int i=0;i<words.length;i++){
                if(!isVisited[i]&&isPossible(words[i],now.word)){
                    isVisited[i]=true;
                    q.add(new Word(words[i],now.cnt+1));
                }
            }
            
        }
        
        
        
    }
    
    public static boolean isPossible(String a,String b){
        
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt!=1){
            return false;
        }
        else{
            return true;
        }
        
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