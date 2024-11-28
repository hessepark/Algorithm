import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<arr.length;i++){
            if(q.isEmpty()||q.peekLast()!=arr[i]){
                q.add(arr[i]);
            }
        }
        
        answer=new int[q.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=q.pollFirst();
        }

        return answer;
    }
}