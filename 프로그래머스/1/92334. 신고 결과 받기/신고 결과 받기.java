import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        //누가 누구 신고
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        //신고 몇번 당함
        HashMap<String, Integer> countMap = new HashMap<>();
        //동일 신고 1회 처리 set
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<report.length;i++) {
            if(set.contains(report[i])) continue;
            
            set.add(report[i]);
            
            String [] people = report[i].split(" ");
            String a=people[0];
            String b=people[1];
            
            if(!map.containsKey(a)) {
                map.put(a,new ArrayList<>());
            }
            
            map.get(a).add(b);
            countMap.put(b,countMap.getOrDefault(b,0)+1);     
        }
        
        //System.out.println(map);
        //System.out.println(countMap);
        
        answer=new int[id_list.length];
        
        int idx=0;
        for(String id :id_list) {
            int cnt=0;
            for(String people:map.getOrDefault(id,new ArrayList<>())){
                if(countMap.get(people)>=k){
                    cnt++;
                }
            }
            answer[idx++]=cnt;
        }
      
        
        return answer;
    }
}