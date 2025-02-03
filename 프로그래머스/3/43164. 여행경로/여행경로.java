import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<String>list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        isVisited=new boolean[tickets.length];
        
        Arrays.sort(tickets,(o1,o2)->{
            if(o1[0].compareTo(o2[0])==0){
                return o1[1].compareTo(o2[1]);
            }
            else{
                return o1[0].compareTo(o2[0]);
            }
        });
        
        list.add("ICN");
        dfs("ICN",tickets);
        
        return list.toArray(new String[0]);
    }
    
    public static void dfs(String cur,String[][] tickets){
        
        if(list.size()==tickets.length+1){
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!isVisited[i]&&tickets[i][0].equals(cur)){
                list.add(tickets[i][1]);
                isVisited[i]=true;
                dfs(tickets[i][1],tickets);
                if(list.size()==tickets.length+1){
                    return;
                }
                isVisited[i]=false;
                list.remove(list.size()-1);
            }
        }
        
    }
}