import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String,Integer>totals =new HashMap<>();
        HashMap<String, HashMap<Integer,Integer>> map = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            totals.put(genres[i],totals.getOrDefault(genres[i],0)+plays[i]);
            
            if(!map.containsKey(genres[i])){
                HashMap<Integer,Integer>list = new HashMap<>();
                list.put(i,plays[i]);
                
                map.put(genres[i],list);
            }
            else{
                map.get(genres[i]).put(i,plays[i]);
            }
        }
        
        ArrayList<String> totalOrder = new ArrayList<>(totals.keySet());
        
        Collections.sort(totalOrder,(o1,o2)->Integer.compare(totals.get(o2),totals.get(o1))); //내림차순
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        for(int i=0;i<totalOrder.size();i++){
            String genre= totalOrder.get(i);
            
            ArrayList<Integer>idx = new ArrayList<>(map.get(genre).keySet());
            
            Collections.sort(idx,(o1,o2)->Integer.compare(map.get(genre).get(o2),map.get(genre).get(o1)));
            
            int cnt=0;
            
            while(cnt<2&&idx.size()>cnt){
                ans.add(idx.get(cnt++));
            }
        }
        
        answer=new int[ans.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=ans.get(i);
        }
        
        return answer;
       
    }
}