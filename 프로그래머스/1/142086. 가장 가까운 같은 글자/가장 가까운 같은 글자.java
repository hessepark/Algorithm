import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        answer = new int[s.length()];
        
     
        for(int i=0;i<s.length();i++){
            int idx=-1;
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    idx=j;
                }
            }
            if(idx!=-1){
                answer[i]=i-idx;
            }
            else{
                answer[i]=idx;
            }
        }
        
        return answer;
    }
}