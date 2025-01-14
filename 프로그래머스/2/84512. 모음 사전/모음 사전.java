import java.io.*;
import java.util.*;

class Solution {
    
    public static char alpha[] = {'A','E','I','O','U'};
    public static int ans;
    public static boolean isFind;
    
    public int solution(String word) {
        ans = 0;
        isFind=false;
        
        dfs("",word);
        
        return ans;
    }
    
    public static void dfs(String now,String word) {
        
        if(now.equals(word)){
            isFind=true;
           // System.out.println("정답: "+now+" 도달: "+ans);
            return;
        }
        
        if(now.length()==5){
           // System.out.println("도달 "+now);
            return;
        }
        
        for(int i=0;i<alpha.length;i++){
            ans++;
           // System.out.println(now);
            dfs(now+alpha[i],word);
            if(isFind){
                return;
            }
             //System.out.println("리턴 "+now +" i: "+i);
        }
        
        
    }
}