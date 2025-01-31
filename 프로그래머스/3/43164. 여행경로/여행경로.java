import java.util.*;
import java.io.*;

class Solution {
    
    public static ArrayList<String>list = new ArrayList<>();
    public static boolean[] isVisited;
    
    public String[] solution(String[][] tickets) {
        
        String[] answer = {};
        
        isVisited=new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1,o2)->{
                   if(o1[0].compareTo(o2[0])==0){
                       return o1[1].compareTo(o2[1]);
                   }
                   return o1[0].compareTo(o2[0]);
        });
        
        // for(int i=0;i<tickets.length;i++){
        //     System.out.println(tickets[i][0]+" "+tickets[i][1]);
        // }
        
        list.add("ICN");
        dfs("ICN",tickets);
        
        answer = new String[list.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }

        
        return answer;
    }
    
    public static void dfs(String city,String[][] tickets){
    
        //System.out.println("나 list야"+list+"나 티켓 길이야"+tickets.length);
        
        if(list.size()==tickets.length+1){
            //System.out.println("지금 리턴:");
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!isVisited[i]){
                 if(city.equals(tickets[i][0])){
                   isVisited[i]=true;
                   list.add(tickets[i][1]);
                   //System.out.println(list+" "+i); //
                   dfs(tickets[i][1],tickets);
                   if(list.size()==tickets.length+1){
                     //  System.out.println("리턴 되는 중:"+list);
                       return;
                   }
                   isVisited[i]=false;
                   list.remove(list.size()-1);
               }
             }
        }
        
        
    }
    
}