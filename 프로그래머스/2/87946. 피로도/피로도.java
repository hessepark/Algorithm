import java.util.*;
import java.io.*;

//순열


class Solution {
    
    
public static boolean isVisited[];
public static int max;
    
    public int solution(int k, int[][] dungeons) {   
        max=Integer.MIN_VALUE;
        
        isVisited=new boolean[dungeons.length];
        
        
        //for(int i=0;i<dungeons.length;i++) { //모든 던전을 출발지로 삼음
            perm(k,dungeons,0); //현재 피로도 ,던전, 위치, 깊이 
        //}
        
        return max;
    }
    
    public static void perm(int current,int[][] dungeons,int cnt){
        

         
        max=Math.max(cnt,max); //최대 갱신
        
        for(int i=0;i<dungeons.length;i++){
            if(!isVisited[i]&&!(current<dungeons[i][0])){
                isVisited[i]=true;
                perm(current-dungeons[i][1],dungeons,cnt+1);
                isVisited[i]=false;
            }
        }
        
    
    }
    
}