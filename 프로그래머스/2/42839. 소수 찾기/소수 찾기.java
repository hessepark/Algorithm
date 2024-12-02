import java.util.*;
import java.io.*;

class Solution {

//perm (isVisited[]) 이해
//추가 조건문 처리 이해
//소수 계산 이해
//(순열을 만들면서) 모든 깊이를 다 탐색해서 완전탐색 
    
    public static HashSet<Integer> set;// 11,011 같다
    public static int ans;
    public static boolean isVisited[];
    
    public int solution(String numbers) {
        ans = 0;
        set = new HashSet<>();
        isVisited = new boolean[numbers.length()+1];
        
        for(int i=1;i<=numbers.length();i++) { //모든 깊이 다 탐색
            perm("",i,numbers);//현재 값,깊이,단어
        }
        
        return ans;
    }
    
    public static void perm(String current, int depth,String numbers) {
        if(current.length()==depth){
            if(isPrime(Integer.parseInt(current))){
                ans++;
                set.add(Integer.parseInt(current));
            }
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                perm(current+numbers.charAt(i),depth,numbers);//ex) numbers:"011" depth:2이면 01로 갔다가 current는 따로
                                                              //변수에 저장이 되어있는 게 아니어서 다시 0으로 돌아갔다가 뒤에 1과 01이                                                               //된다.
                isVisited[i]=false;
            }
        }
        
    }
    
    public static boolean isPrime(int num){
    
        if(set.contains(num)){
            return false;
        }
        
        if(num<2){
            return false;
        }
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        
        return true;
    
    }
    
}