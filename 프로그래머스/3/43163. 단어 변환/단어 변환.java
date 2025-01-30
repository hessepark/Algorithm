import java.util.*;
import java.io.*;

class Solution { //큐에 길이 넣어놓고 뽑혔을 때 그만하기
    
    public static int visited[];
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited=new int[words.length];
        
        ArrayDeque<Word>q = new ArrayDeque<>();
        q.add(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            
            //System.out.println("현재 내 값:"+now.cnt);
            
            if(now.word.equals(target)){
                return now.cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(visited[i]==0&&isPossible(now.word,words[i])){
                    visited[i]=now.cnt+1;
                    //System.out.println("비교: "+now.word+" "+words[i]+" "+visited[i]);
                    q.add(new Word(words[i],visited[i]));
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
            if(cnt>1){
                return false;
            }
        }
        
        if(cnt==1)
            return true;
        
        return false;
        
    }
}

class Word {
    String word;
    int cnt;
    public Word (String word, int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}