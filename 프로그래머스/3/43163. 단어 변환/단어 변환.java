import java.io.*;
import java.util.*;
class Solution {
    
    public static boolean[] isVisited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        isVisited=new boolean[words.length];
        
        answer=bfs(words,begin,target);
        
        return answer;
    }
    
    public static int bfs(String[] words,String begin,String target){
        
        ArrayDeque<Data>q = new ArrayDeque<>();
        q.add(new Data(begin,0));
        
        while(!q.isEmpty()){
            
            Data now = q.poll();
            
            if(now.word.equals(target)){
                //System.out.println("여기:"+now.cnt);
                return now.cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(check(words[i],now.word)&&!isVisited[i]){
                    isVisited[i]=true;
                    q.add(new Data(words[i],now.cnt+1));
                    //System.out.println(words[i]);
                }
            }
            
            
        }
        return 0;
        
    }
    
    public static boolean check(String a,String b){
        
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt==1)return true;
        else return false;
        
        
    }
}


class Data {
    String word;
    int cnt;
    
    public Data(String word,int cnt) {
        this.word=word;
        this.cnt=cnt;
    }
}