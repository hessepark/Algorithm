import java.util.*;
import java.io.*;

// 시작점이 ICN인 것들 따로 관리 idx 저장
// 알파벳순서로 ATL, SFO순 인덱스 정렬
// 인덱스 순서대로 dfs 시행

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<String>answer=new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        //String[] answer = new String[tickets.length+1];
        
   
        
        ArrayList<Integer>startIndex = new ArrayList<>();
        
         Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                startIndex.add(i);
            }
        }
        
        Collections.sort(startIndex,(o1,o2)->tickets[o1][1].compareTo(tickets[o2][1]));
      // System.out.println(startIndex);
        
        for(int i=0;i<startIndex.size();i++){
            //다 가봤으면 뒤에거 볼 필요 아예 없어짐
            if(answer.size()!=tickets.length+1){ //answer 초기화 안 됐는데 이게 된다고?   

                answer = new ArrayList<>();
                isVisited=new boolean[tickets.length];
                
                int si=startIndex.get(i);
                
                isVisited[si]=true;
                answer.add(tickets[si][0]);
                answer.add(tickets[si][1]);
                dfs(si,tickets);
            }
            }
        
       // System.out.println(answer);
        
        String[] ans = new String[tickets.length+1];
        
        for(int i=0;i<ans.length;i++){
            ans[i]=answer.get(i);
        }
        
        
        return ans;
    }
    
    public static void dfs(int num,String[][] tickets){
        
        if(answer.size()==tickets.length+1){
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!isVisited[i]&&tickets[num][1].equals(tickets[i][0])){
               // System.out.println(tickets[num][1]);
                //System.out.println(tickets[i][0]);
                answer.add(tickets[i][1]);
                isVisited[i]=true;
                dfs(i,tickets);
                if(answer.size()==tickets.length+1){ // 다 찾으면 false로 안 바꾸고 return하니까 끝남
                   return;
                 }
                isVisited[i]=false;
                answer.remove(answer.size()-1);
                
            }
            
            
        }
       
        
    }
}