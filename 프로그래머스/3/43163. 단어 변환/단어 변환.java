//bfs로 번지다가 도착하면 바로 종료

import java.util.*;
import java.io.*;

class Solution {
    
    public static int ans;
    public static int visited[];
    
    public int solution(String begin, String target, String[] words) {
        ans = 0;
        
        visited=new int[words.length];
        
        bfs(begin,target,words);
        
        return ans;
    }
    
    public static void bfs(String cur,String target,String[] words){
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        //출발 가능한 지점을 q에 다 넣는다
         for(int i=0;i<words.length;i++){
            if(check(words[i],cur)){
                q.add(i);
                visited[i]=1;
               System.out.println(i);
                
                  if(words[i].equals(target)){ //ans가 처음으로 나오면
                    ans=visited[i];
                    break;
                }
                
            }
        }
        
        if(ans!=0) return;
        
        //System.out.println(q);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i=0;i<words.length;i++){
                if(visited[i]==0&&check(words[now],words[i])){
                    visited[i]=visited[now]+1;
                    q.add(i);
                    System.out.println(i);
                     if(words[i].equals(target)){ //ans가 처음으로 나오면
                    ans=visited[i];
                    break;
                }
                }
               
            }
            if(ans!=0){
                break;
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