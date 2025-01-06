import java.util.*;
import java.io.*; 

class Solution {
    
    public static ArrayList<String>answer;
    public static boolean isVisited[];
    
    public String[] solution(String[][] tickets) {
        
        answer = new ArrayList<>();
        isVisited = new boolean[tickets.length];
        
        Arrays.sort(tickets,(a,b)-> {
          if(a[0].compareTo(b[0])==0){ //출발지가 같으면
              return a[1].compareTo(b[1]); //도착지 기준 오름차순
          } 
          else{
              return a[0].compareTo(b[0]); //출발지 다르면 출발지 오름차순
          }
        });
        
//         for(int i=0;i<tickets.length;i++){
//             for(int j=0;j<tickets[0].length;j++){
//                 System.out.print(tickets[i][j]+" ");
//             }
//             System.out.println();
//         }
        
//         System.out.println("도착지 기준");
        
//         Arrays.sort(tickets,(a,b)-> {
//           if(a[1].compareTo(b[1])==0){ //도착지가 같으면
//               return a[0].compareTo(a[0]); //출발지 기준 오름차순
//           } 
//           else{
//               return a[1].compareTo(b[1]); //도착지 다르면 도착지 오름차순
//           }
//         });
        
//         for(int i=0;i<tickets.length;i++){
//             for(int j=0;j<tickets[0].length;j++){
//                 System.out.print(tickets[i][j]+" ");
//             }
//             System.out.println();
//         }
        answer.add("ICN");
        dfs("ICN",tickets);
        
        
        return answer.toArray(new String[0]);
    }
    
    public static void dfs(String cur,String [][] tickets){
        
        // if(answer.size()==tickets.length+1){
        //     return;
        // }
        
        for(int i=0;i<tickets.length;i++){
            if(!isVisited[i]&&tickets[i][0].equals(cur)){
                isVisited[i]=true;
                answer.add(tickets[i][1]);
                dfs(tickets[i][1],tickets);
                   if(answer.size()==tickets.length+1){
            return;
        }
                isVisited[i]=false;
                answer.remove(answer.size()-1);
            }
        }
        
    }
}