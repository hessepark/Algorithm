import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer>list = new ArrayList<>();
        
        int preNum=10; //전에 어떤 값이 나왔는지를 항상 기억한다.
        
        for(int i=0;i<arr.length;i++){
            if(preNum!=arr[i]){
                list.add(arr[i]);
            }
             preNum=arr[i];
        }
        
        answer=new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}