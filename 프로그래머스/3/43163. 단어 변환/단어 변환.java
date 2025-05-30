import java.util.*;
import java.io.*;
class Solution {
    public static boolean isVisited[];
    public int solution(String begin, String target, String[] words) {
        int cnt = 0;
        
        isVisited=new boolean[words.length];
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        q.add(new Word(begin,0));
        
        while(!q.isEmpty()){
            
            Word now = q.poll();
            if(now.word.equals(target)){
                return now.num;
            }
            
            for(int i=0;i<words.length;i++){
                if(!isVisited[i]&&isCount(words[i],now.word)==1){
                    isVisited[i]=true;
                    q.add(new Word(words[i],now.num+1));
                }
            }
            
        }
        
        return cnt;
    }
    
    public static int isCount(String a,String b) {
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
    int num;
    public Word(String word,int num){
        this.word=word;
        this.num=num;
    }
}