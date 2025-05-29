import java.util.*;
import java.io.*;

class Solution {
    public String solution(String new_id) {
        
        //1
        new_id=new_id.toLowerCase();
        
        
        //2
        StringBuilder sb = new StringBuilder();
        for(char c:new_id.toCharArray()){
            if(c>='a'&&c<='z'||c>='0'&&c<='9'||c=='-'||c=='_'||c=='.'){
                sb.append(c);
            }
        }
        
        new_id=sb.toString();
        sb=new StringBuilder();
        
        boolean isPeriod=false;
        for(int i=0;i<new_id.length();i++){
            char c =new_id.charAt(i);
            if(c=='.'){
                isPeriod=true;
            }
            else{
                if(isPeriod){
                    sb.append('.');
                }
                sb.append(c);
                isPeriod=false;
            }
        }
        
        new_id=sb.toString();
        sb=new StringBuilder();
        
        
        //4
        if(new_id.startsWith(".")){
            new_id=new_id.substring(1,new_id.length());
        }
        
        if(new_id.endsWith(".")){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        
        //5
        if(new_id.length()==0){
            new_id+="a";
        }
        
        //6
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
                 if(new_id.endsWith(".")){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        }
        
        //7
        char c = new_id.charAt(new_id.length()-1);
        while(new_id.length()<=2){
            new_id+=c;
        }
        
        
        return new_id;
        
    }
}