import java.util.*;
import java.io.*;

//모든 지점에서 시작해서 갈 수 있는 던전을 계속 가보면서 최댓값 갱신
//순열. 현재 남은 피로도를 기억하고 있어야한다.
//가보고 안 되면 return; 갈 수 있으면 계속 간다.

class Solution {
    
    public static boolean isVisited[];
    public static int max;
    
    public int solution(int k, int[][] dungeons) {
        max = Integer.MIN_VALUE;
        
        isVisited=new boolean[dungeons.length];
       
        
        for(int i=0;i<dungeons.length;i++){ //모든 던전을 출발점으로 둬봄
            perm(k,dungeons,i,1); //현재 피로도(k에서 출발),현재 도착한 던전,현재 길이
            System.out.println(Arrays.toString(isVisited));
        }
        
        return max;
    }
    
    public static void perm(int current,int[][] dungeons,int pos,int cnt){

        if(current<dungeons[pos][0]){
            return;
        }
        
        isVisited[pos]=true;
        
        max=Math.max(cnt,max);
        
        for(int i=0;i<dungeons.length;i++){
            if(!isVisited[i]){
                //System.out.println(i);
                perm(current-dungeons[pos][1],dungeons,i,cnt+1);
                isVisited[i]=false;
            }
        }
        
        isVisited[pos] = false; //처음 방문한 노드도 돌려줘야함 처음에 얘를 간과했다.
        
        
    
    }
    
}