import java.util.*;
import java.io.*;

class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder();
        
        new_id = new_id.toLowerCase(); //1단계
        
        
        for(int i=0;i<new_id.length();i++){ //2단계
            char c = new_id.charAt(i);
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')||c=='-'||c=='_'||c=='.'){
                sb.append(c);
            }
        }
        
        new_id=sb.toString();
        
        sb = new StringBuilder();
        
        //3단계
        boolean isFlag = false;
        for(int i=0;i<new_id.length();i++){ // new_id.toCharArray()
            char c = new_id.charAt(i);
            if(c=='.'){
                if(!isFlag){
                    sb.append(c);
                    isFlag=true;
                }
            }
            else{
                sb.append(c);
                isFlag=false;
            }
        }
        
        new_id = sb.toString();
        
        //4단계
        if(new_id.startsWith(".")){
            new_id=new_id.substring(1);
        }
        
        if(new_id.endsWith(".")){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        
        //5단계
        if(new_id.length()==0){
            new_id+="a";
        }
        
        //6단계
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
        }
        
        if(new_id.endsWith(".")){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        
        //7단계
        if(new_id.length()<=2){
            char c = new_id.charAt(new_id.length()-1); //마지막 문자
            
            while(new_id.length()<=2){
                new_id+=c;
            }
        }
        
        return new_id;
        
        
    }
}