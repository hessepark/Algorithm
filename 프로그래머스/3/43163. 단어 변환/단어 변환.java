//안 가본 곳이고 한 글자만 다르면 계속 들어간다
//들어가다가 target이랑 같으면 return;
//for문 끝나면 갔던곳 원복

import java.util.*;
import java.io.*;


class Solution {
    
    public static int ans;
    public static boolean[] isVisited;
    
    public int solution(String begin, String target, String[] words) {
        ans=0;
        isVisited =new boolean[words.length];
        
        dfs(begin,target,words,0);
        
        return ans;
    }
    
    public static void dfs(String cur, String target,String[] words,int cnt){
        
        if(cur.equals(target)){
            ans=cnt;
            return;
        }
        
        //깊이가 끝까지 갔으면?
        
        for(int i=0;i<words.length;i++){
            if(!isVisited[i]){
                if(compare(cur,words[i])){ //함수 충족하면
                    isVisited[i]=true;
                    dfs(words[i],target,words,cnt+1);
                    isVisited[i]=false;
                }
            }
        }
        
        
    }
    
    public static boolean compare(String a,String b){
        
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