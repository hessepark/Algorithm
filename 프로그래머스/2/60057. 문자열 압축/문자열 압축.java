import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length()==1){
            return 1;
        }
        
        for(int i=1;i<=s.length()/2;i++) {
            answer=Math.min(answer, compress(s,i));
        }
        
        return answer;
    }
    
    
    public int compress(String s, int l) {
        
        ArrayDeque<Alpha>q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i+=l){
            String sub=s.substring(i,Math.min(s.length(),i+l));
            
            if(q.isEmpty()){
                q.addLast(new Alpha(1,sub));
            }
            else {
                Alpha next=q.peekLast();
                if(q.peekLast().a.equals(sub)){
                    q.pollLast();
                    q.addLast(new Alpha(next.cnt+1,next.a));
                }
                else{
                    q.addLast(new Alpha(1,sub));
                }
            }
        }
        
        while(!q.isEmpty()) {
            Alpha sub=q.pollFirst();
            if(sub.cnt>=2){
                sb.append(sub.cnt);
            }
            sb.append(sub.a);
        }
        
        //System.out.println(sb);
        
        return sb.length();
        
    }
    
}

class Alpha {
    int cnt;
    String a;
    
    public Alpha(int cnt, String a) {
        this.cnt=cnt;
        this.a=a;
    }
}