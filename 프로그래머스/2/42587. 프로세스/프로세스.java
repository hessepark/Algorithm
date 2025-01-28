import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Integer[] list=new Integer[priorities.length];
        
        for(int i=0;i<priorities.length;i++){
            list[i]=priorities[i];
        }
        
        Arrays.sort(list,Collections.reverseOrder());
        
        ArrayDeque<Integer>q = new ArrayDeque<>();
        for(int i=0;i<list.length;i++){
            q.add(list[i]);
        }
        
        int cnt=1;
        
        while(true){
            
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==q.peekFirst()){
                    if(location==i){
                        return cnt;
                    }
                    q.poll();
                    cnt++;
                }
            }
            
            
        }
       
        //return answer;
    }
}