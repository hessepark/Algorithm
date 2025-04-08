import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String,Integer>map = new HashMap<>();
        

        for(int i=0;i<phone_book.length;i++){
            map.put(phone_book[i],1);
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(map.getOrDefault( phone_book[i].substring(0,j) ,0)==1){
                    System.out.println(phone_book[i].substring(0,j) +" 현재 나:"+phone_book[i]);
                    return false;
                }
            }
            
        }
        
        return answer;
    }
}