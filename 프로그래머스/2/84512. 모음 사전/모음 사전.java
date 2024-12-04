import java.util.*;
import java.io.*;

class Solution {
   
    public static int cnt;
    public static int ans;
    public static char arr[]={'A','E','I','O','U'};
    
    public int solution(String word) {
        
        ans=0;
        cnt = 0;
        
        make("",word); // 깊이
        
        //ans=cnt;
        
        return ans;
    
    }
    
    public static void make(String cur,String word){
        
        if(cur.equals(word)){
            ans=cnt;
            return;
        }
        
        for(int i=0;i<5;i++){
            //System.out.println(cur+arr[i]);
            if(cur.length()<5){
                cnt++;
                make(cur+arr[i],word);
            };
        }
        
        
    }
}