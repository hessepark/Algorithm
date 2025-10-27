import java.util.*;
import java.io.*;

class Solution {
    
    public static ArrayList<String>list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length];
        
        Arrays.sort(tickets,(o1,o2)-> {
            if(o1[0].compareTo(o2[0])==0){
                return o1[1].compareTo(o2[1]);   
            } else{
                return o1[0].compareTo(o2[0]);
            }
        });
        
        boolean isVisited[]=new boolean[tickets.length];
        list.add("ICN");
        dfs("ICN",isVisited,tickets);
        
        answer = new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(String word,boolean[] isVisited,String[][] tickets) {
        
        
        
        for(int i=0;i<tickets.length;i++){
            if(!isVisited[i]){
                if(tickets[i][0].equals(word)){
                    list.add(tickets[i][1]);
                    isVisited[i]=true;
                    dfs(tickets[i][1],isVisited,tickets);
                    if(list.size()==tickets.length+1){
                        return;
                    }
                    list.remove(list.size()-1);
                    isVisited[i]=false;
                }
            }
        }
        
    }
    
}