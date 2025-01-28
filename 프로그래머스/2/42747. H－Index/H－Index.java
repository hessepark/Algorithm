import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        ArrayList<Integer>list = new ArrayList<>();
        
        for(int i=0;i<citations.length;i++){
            list.add(citations[i]);
        }
        
        Collections.sort(list,Collections.reverseOrder()); //Integer type 배열이면 Arrays.sort도 가능
        
        for(int i=0;i<citations.length;i++){
            if(list.get(i)<i+1){
                return i;
            }
        }
        
        return list.size();
        
        }
}