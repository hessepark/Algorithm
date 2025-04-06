import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs,(o1,o2)->Integer.compare(o1[0],o2[0])); //일단 시간 안에 있어야 실행 가능
        
        PriorityQueue<int[]>q= new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        
        int count=0;
        int idx=0; //현재 보고있는 index
        int time=0; //현재 시간
        
        while(count<jobs.length){
            
            while(idx<jobs.length&&jobs[idx][0]<=time){
                q.add(jobs[idx]);
                idx++;
            }
            
            if(!q.isEmpty()){
                int job[]=q.poll();
                 time+=job[1];
                 answer+=time-job[0];
                count++;
            }
            else{
                time++;
            }
            
        }
        
        return answer/jobs.length;
    }
}