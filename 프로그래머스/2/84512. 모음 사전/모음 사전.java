import java.util.*;
import java.io.*;

class Solution {
    
    public static int ans;
    public static int num;
    public static char[] alpha= {'A','E','I','O','U'};
    
    public int solution(String word) {
        ans=0;
        
        dfs("",word);
        
        return ans;
    }
    
    public static void dfs (String cur,String word){
        
       // System.out.println(cur);
        
        
        if(cur.equals(word)){
            System.out.println(num);
            ans=num;
            return;
        }
        
        if(cur.length()==5){
            return;
        }
        
        for(int i=0;i<5;i++){
            num++;
            dfs(cur+alpha[i],word);
            if(ans!=0){
                return;
            }
        }
        
    }
    
}