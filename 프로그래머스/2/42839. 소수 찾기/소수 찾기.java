import java.util.*;
import java.io.*;

class Solution {
    
    public static HashSet<Integer>set;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        
        boolean isVisited[]=new boolean[numbers.length()];
        
        dfs(0,0,isVisited,numbers);
        
        return set.size();
    }
    
    public static void dfs(int num, int depth, boolean[] isVisited, String numbers) {
        
        if(isPrime(num)&&!set.contains(num)){
            set.add(num);
        }
        
        if(depth==numbers.length()){
            return;
        }
        
        for(int i=0;i<numbers.length();i++) {
            if(!isVisited[i]){
                isVisited[i]=true;
                dfs(num*10+numbers.charAt(i)-'0',depth+1,isVisited,numbers);
                isVisited[i]=false;
            }
        }
        
    }
    
    public static boolean isPrime(int num){
        
        if(num<=1) return false;
        
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num%i==0){
                return false;
            }
        }
        
        return true;
        
    }
}