import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int isVisited[]=new int[words.length];
        
        ArrayDeque<Word>q=new ArrayDeque<>();
        q.add(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word word=q.poll();
            for(int i=0;i<words.length;i++){
                if(isVisited[i]==0&&isSimilar(word.word,words[i])){
                    System.out.print(words[i]+" ");
                    System.out.println(word.cnt+1);
                    q.add(new Word(words[i],word.cnt+1));
                    isVisited[i]=word.cnt+1;
                    //System.out.println("비지티드"+isVisited[i]);
                    if(target.equals(words[i])){
                        return isVisited[i];
                    }
                }
            }
            
        }
        
        
        return answer;
    }
    
    public static boolean isSimilar(String a, String b) {
        
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
    int cnt;
    String word;
    public Word(String word,int cnt){
        this.cnt=cnt;
        this.word=word;
    }
}