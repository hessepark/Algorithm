import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb;
        
        String str[]=new String[s.length()];
        
        for(int i=0;i<s.length();i++){
            str[i] = s.charAt(i)+"";
        }
        
        int idx=0;
        
        for(int i=0;i<s.length();i++){
            
            if(str[i].equals(" ")){
                idx=0;
                continue;
            }
            
            if(idx%2==0){
                str[i]=str[i].toUpperCase();
            }
            else{
                str[i]=str[i].toLowerCase();
            }
            idx++;
        }
        
        sb=new StringBuilder();
        
        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
        }
        
        
        return sb.toString();
    }
}