import java.util.*;
import java.io.*;

class Solution {
    
    public static int isVisited[];
    public static int max;
    public static ArrayList<Integer>list[];
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        isVisited=new int[n+1];
        max=Integer.MIN_VALUE;
        
        list=new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
            list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++) {
            int e1=edge[i][0];
            int e2=edge[i][1];
            list[e1].add(e2);
            list[e2].add(e1);
        }
        
        bfs(list,1);
        
        for(int i=1;i<=n;i++) {
            if(isVisited[i]==max){
                answer++;
            }
        }
        
        System.out.println(Arrays.toString(isVisited));
        
        return answer;
    }
    
    public static void bfs(ArrayList<Integer>list[],int n) {
        ArrayDeque<Integer>q = new ArrayDeque<>();
        q.add(n);
        isVisited[n]=1;
        
        while(!q.isEmpty()) {
            int num=q.poll();
            ArrayList<Integer>tmp=list[num];
            for(int i=0;i<tmp.size();i++){
                if(isVisited[tmp.get(i)]==0){
                    isVisited[tmp.get(i)]=isVisited[num]+1;
                    max=Math.max(isVisited[tmp.get(i)],max);
                    q.add(tmp.get(i));
                }
            }
        }
    }
}