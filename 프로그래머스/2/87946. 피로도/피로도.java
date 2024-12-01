import java.util.*;
import java.io.*;

//순열


class Solution {
    
    
public static boolean isVisited[];
public static int max;
    
    public int solution(int k, int[][] dungeons) {   
        max=Integer.MIN_VALUE;
        
        isVisited=new boolean[dungeons.length];
        
        
        for(int i=0;i<dungeons.length;i++) { //모든 던전을 출발지로 삼음
            perm(k,dungeons,i,1); //현재 피로도 ,던전, 위치, 깊이 
        }
        
        return max;
    }
    
    public static void perm(int current,int[][] dungeons,int pos,int cnt){
        
        if(current<dungeons[pos][0]){
            return; //못 간다
        }
        
        isVisited[pos]=true;
        
        max=Math.max(cnt,max); //최대 갱신
        
        for(int i=0;i<dungeons.length;i++){
            if(!isVisited[i]){
                perm(current-dungeons[pos][1],dungeons,i,cnt+1);
            }
        }
        
        isVisited[pos]=false;
        
    
    }
    
}