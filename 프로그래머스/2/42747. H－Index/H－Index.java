import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        ArrayList<Integer>list = new ArrayList<>();
        
        for(int i=0;i<citations.length;i++){
            list.add(citations[i]);
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
        for(int i=0;i<list.size();i++){
            if(list.get(i)<i+1){
                return i;
            }
        }
        
        return list.size();
    }
}