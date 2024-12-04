import java.util.*;
import java.io.*;

class Solution {
   
    public static boolean found;
    public static int cnt;
    public static int ans;
    public static char arr[]={'A','E','I','O','U'};
    
    public int solution(String word) {
        
        ans=0;
        cnt = 0;
        found = false;
        
        make("",0,word); // 깊이
        
        //ans=cnt;
        
        return ans;
    
    }
    
    public static void make(String cur,int depth,String word){
        
        if(cur.equals(word)){
            ans=cnt;
            found=true;
            return;
        }
        
        if(depth==5){
            return;
        }
        
        for(int i=0;i<5;i++){

            if(found){
                return;
            }
            
            //System.out.println(cur+arr[i]);
           // if(cur.length()<5){ //깊이를 cur.length()로 대신한 거임
           
                cnt++;
                make(cur+arr[i],depth+1,word);
            
           // };
        }
        
        
    }
}