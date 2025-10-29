import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer>countSum=new HashMap<>();
        HashMap<String, HashMap<Integer,Integer>>countMap = new HashMap<>();
        
        for(int i=0;i<plays.length;i++) {
            countSum.put(genres[i],countSum.getOrDefault(genres[i],0)+plays[i]);
            
            if(!countMap.containsKey(genres[i])){
                countMap.put(genres[i],new HashMap<Integer,Integer>());
            }
            countMap.get(genres[i]).put(i,plays[i]);
        }
        
        ArrayList<String>list = new ArrayList<>(countSum.keySet());
        
        Collections.sort(list,(o1,o2)->Integer.compare(countSum.get(o2),countSum.get(o1)));
        
        //System.out.println(list);
        
        for(int i=0;i<list.size();i++) {   
            HashMap<Integer,Integer>idxMap = new HashMap<>(countMap.get(list.get(i)));
            
            ArrayList<Integer>idxList = new ArrayList<>(countMap.get(list.get(i)).keySet());
            Collections.sort(idxList, (o1,o2)->Integer.compare(idxMap.get(o2),idxMap.get(o1)));
            //System.out.println(idxList);
            
            int idx=0;
            
            while(idx<2&&idxList.size()>idx) {
                answer.add(idxList.get(idx++));
            }
        }
        
        int ans[]=new int[answer.size()];
        
        for(int i=0;i<answer.size();i++) {
            ans[i]=answer.get(i);
        }
        

        //System.out.println(countSum);
        //System.out.println(countMap);
        
        return ans;
    }
}