import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<String> answer;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        
        isVisited=new boolean[tickets.length];
        
        //1차원 배열이 리턴되는지는 확인
        Arrays.sort(tickets, (a,b)->{ //a,b에는 1차원 배열이 리턴됨
                   if(a[0].equals(b[0])) // 첫 번째 값이 같으면 두 번째 값으로 정렬
                    return a[1].compareTo(b[1]);
                   else{
                       return a[0].compareTo(b[0]); //다르면 첫 번째로 정렬
                   }
            });
        
       // for(int i=0;i<tickets.length;i++){
       //     System.out.println(tickets[i][0]+","+tickets[i][1]);
        //}
        
        answer.add("ICN");
        dfs("ICN",tickets);
       
        
        return answer.toArray(new String[0]);
    }
    
    public static void dfs(String cur,String tickets[][]){
        
        if(answer.size()==tickets.length+1){
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!isVisited[i]&&cur.equals(tickets[i][0])){
                isVisited[i]=true;
                answer.add(tickets[i][1]);
                dfs(tickets[i][1],tickets);
                if(answer.size()==tickets.length+1){
            return;
        }
                isVisited[i]=false; //못가면 안 간셈 치고
                answer.remove(answer.size()-1); //결과값에서도 지워줘야함
                
            }
        }
        
        
    }
}