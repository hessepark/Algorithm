import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer>q = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 큐
        
        for(int i=0;i<priorities.length;i++){
            q.add(priorities[i]);
        }
        
        //System.out.println(q);
        int idx=0;
        
        int num = q.poll(); //처음에 하나 뽑음
        
        while(true){
            
        for(int i=0;i<priorities.length;i++){ //같은 거 나올 때까지 간다
            if(num==priorities[i]){ //같은 거 나오면 인덱스 하나 증가
                idx++;
                if(location==i){ //location거 뽑으면 중단
                    //System.out.println(idx);
                    return idx;
                }
                 num=q.poll(); //아니면 새 num을 뽑아서 테스트함
            }
        }
        
        }
        
        
        //return answer;
    }
}