import java.util.*;
import java.io.*;
class Solution {
    public int solution(String s) {
        int min=s.length();
        
        for(int l=1;l<=s.length()/2;l++){
            min=Math.min(min,compress(s,l));
        }
        
        return min;
    }
    
    
    public static int compress(String s, int length) {
    
        int count=1;
        String prev="";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i+=length){
            String str =s.substring(i,Math.min(s.length(),i+length));
            if(str.equals(prev)){
                count++;
            }
            else{
                if(count>1){
                    sb.append(count);
                }
                sb.append(prev);
                prev=str;
                count=1;
            }
        }
        
        if(count>1){
            sb.append(count);
        }
        sb.append(prev);
        
        //System.out.println(length+"결과: "+sb.toString());
        
        return sb.toString().length();
        
    }
    
}
