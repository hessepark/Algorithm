import java.util.*;
import java.io.*;

//dfs

class Solution {
    
    public static ArrayList<Integer>list[];
    public static int min; //절대값 차이 최소
    public static boolean isVisited[]; //방문하였는가?
    
    public int solution(int n, int[][] wires) {
        min =Integer.MAX_VALUE;
        
        list =new ArrayList[n+1];
      
        for(int i=1;i<n+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<wires.length;i++) {
            int a=wires[i][0];
            int b=wires[i][1];
            
            list[a].add(b); //연결
            list[b].add(a);
        }
        
        for(int i=0;i<wires.length;i++) { //하나씩 끊어본다.
            int a=wires[i][0];
            int b=wires[i][1];
            //System.out.println(Arrays.toString(list[1].toArray())); 
            list[a].remove(Integer.valueOf(b)); // Integer.valueOf로 줘야함(객체). 아니면 인덱스 넘어간다. 
            list[b].remove(Integer.valueOf(a));
            //System.out.println(Arrays.toString(list[1].toArray())); 

            
            isVisited=new boolean[n+1];
            
            //끊은 상태에서 계산
            int cnt = dfs(1); //1번 송전탑은 무조건 있으니(검증 필요.) 1번 기준
            
            //=System.out.println(cnt);
            //System.out.println(Arrays.toString(isVisited));
            
            min=Math.min(min,Math.abs(cnt-(n-cnt))); //하나의 트리형태니 나머지 계산
            
            list[a].add(b);
            list[b].add(a);
            
        }
        
        return min;
        
    }
    
    public static int dfs(int v){
        isVisited[v]=true; //방문
        int cnt=1;
        
        for(int next:list[v]){
            if(!isVisited[next]) { //방문하지 않았으면
                //System.out.println(next);
                cnt+=dfs(next);
            }
        }
        
        //isVisited[v]=false; //여기서 체크 못 해주나?
        
        return cnt;
    
    }
    
}