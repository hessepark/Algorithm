import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        
        for(int i=0;i<arr.length;i++){
            if(q.isEmpty()){
                q.add(arr[i]);
            }
            else{
                if(q.peekLast()!=arr[i]){
                    q.add(arr[i]);
                }
            }
        }
        
        answer = new int[q.size()];
        
        int idx=0;
        
        while(!q.isEmpty()){
            answer[idx++]=q.pollFirst();
        }

        return answer;
    }
}