import java.util.*;
import java.io.*;

class Solution {
    
    public static HashSet<Integer>set;
    public static boolean isVisited[];
    public static int answer;
    
    public int solution(String numbers) {
        answer =0;
        set = new HashSet<>();
        isVisited=new boolean[numbers.length()];
        
        for(int i=1;i<=numbers.length();i++) {
            perm("",numbers,i);
        }
        
        return answer;
        
    }
    
    public static void perm(String current,String numbers,int depth){

        if(current.length()==depth){
            if(isPrime(Integer.parseInt(current))){
                set.add(Integer.parseInt(current));
                System.out.println(Integer.parseInt(current));
                answer++;
            }
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!isVisited[i]){
            isVisited[i]=true;
            perm(current+numbers.charAt(i),numbers,depth);
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