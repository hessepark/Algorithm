import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //먼저 시간 순 정렬
        Arrays.sort(jobs,(o1,o2)->Integer.compare(o1[0],o2[0]));
        
        //소요시간이 짧은 순서대로 큐에 들어가게 만듦
        PriorityQueue<int[]>q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        
        int time=0; //현재 시각
        //현 시간부로 들어갈 수 있는 친구들 큐에 줄 세움
        int idx=0; //현재 인덱스
        int count=0;
        
        while(count<jobs.length){
            while(idx<jobs.length&&jobs[idx][0]<=time){
                    q.add(jobs[idx++]);
                }
            // if(!q.isEmpty()){
            
            if(q.isEmpty()){
                time++;
                continue;
            }
            
                int num[]=q.poll();
                count++;
                time+=num[1];
                answer+=time-num[0];
            // }
            // else{
            //     time++;
            // }
        }
        
        
        return answer/jobs.length;
    }
}