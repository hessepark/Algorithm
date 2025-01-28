import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer>map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        for(String sort: map.keySet()){
            answer*=map.get(sort)+1;
        }
        
        answer-=1;
        
        
        return answer;
    }
}