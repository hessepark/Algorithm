import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean isVisited[];
    public static ArrayList<Integer> list;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        list = new ArrayList<>();
        isVisited = new boolean[cards.length+1];
        
        for(int i=1;i<=cards.length;i++){
            if(!isVisited[i]){
                bfs(cards,i);
            }
        }
        
        if(list.size()==1){
            return 0;
        }
        
        Collections.sort(list,Collections.reverseOrder());
        return list.get(0)*list.get(1);
        
    }
    
    public static void bfs(int[] cards, int num){
        
        isVisited[num]=true;
        int cnt = 1;
        ArrayDeque<Integer>q = new ArrayDeque<>();

        q.add(num);
        
        while(!q.isEmpty()){
            int next = cards[q.poll()-1];
            if(!isVisited[next]){
                q.add(next);
                isVisited[next]=true;
                cnt++;
            }
        }
        
        list.add(cnt);
        
        
        //i로 하냐, cards[i]로 하냐는 상관 없음.
        //카드가 일렬로 놓여져있으면, 앞에서 첫 번째를 뽑나, 실제 값 1을 뽑나 상관이 없다.
        
    }
}