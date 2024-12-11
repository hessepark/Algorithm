import java.util.*;
import java.io.*;

class Data {
    String word;
    int cnt;
    
    public Data(String word, int cnt){
        this.word=word;
        this.cnt=cnt;
    }
    
}

class Solution {
    
    public static int ans;
    public static boolean isVisited[];
    
    public int solution(String begin, String target, String[] words) {
        ans = 0;
        
        isVisited=new boolean[words.length];
        
        bfs(begin,target,words,0);
       
        
        return ans;
        
        
    }
    
    public static void bfs(String begin,String target,String[]words,int cnt){
        
        ArrayDeque<Data>q = new ArrayDeque<>();
        q.add(new Data(begin,0));
        
        while(!q.isEmpty()){
            Data now = q.poll();
            for(int i=0;i<words.length;i++){
                if(!isVisited[i]&&check(now.word,words[i])){
                    q.add(new Data(words[i],now.cnt+1));
                    isVisited[i]=true;
                  if(words[i].equals(target)){
                        ans=now.cnt+1;
                        // System.out.println(i);
                        //System.out.println(now.word);
                      //return 지움
                    }
                }
                  
            }
        }
        
    }
    
    public static boolean check(String a,String b){
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt!=1){
            return false;    
        }
        return true;
    }
    
}