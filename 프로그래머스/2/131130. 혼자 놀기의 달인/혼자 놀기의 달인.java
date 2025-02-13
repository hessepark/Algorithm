import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer> list;
    public static int depth;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        list = new ArrayList<>();
        isVisited = new boolean[cards.length+1];
        
        for(int i=1;i<=cards.length;i++){//
            if(!isVisited[i]){
                depth=0;
                dfs(cards,i);
                list.add(depth);
            }
        }
        
        if(list.size()==1){
            return 0;
        }
        
        System.out.println(list);
        
        Collections.sort(list,Collections.reverseOrder());
        return list.get(0)*list.get(1);
        
    }
    
    public static void dfs(int[] cards, int num){

        if(!isVisited[num]){
            isVisited[num]=true;
            depth++;
            int next = cards[num-1];
            System.out.println("방문: "+num);
            dfs(cards,next);
        }
        
        
        
        //i로 하냐, cards[i]로 하냐는 상관 없음.
        //카드가 일렬로 놓여져있으면, 앞에서 첫 번째를 뽑나, 실제 값 1을 뽑나 상관이 없다.
        
        return;
    }
}