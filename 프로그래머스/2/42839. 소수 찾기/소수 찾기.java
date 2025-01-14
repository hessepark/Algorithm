import java.util.*;
import java.io.*;

class Solution {
    
    public static HashSet<Integer>set;
    public static boolean[] isVisited;
    public static int ans;
    
    public int solution(String numbers) {
        ans = 0;
        set = new HashSet<>();
        isVisited = new boolean[numbers.length()];
        
        perm(0,0,numbers);//현재 숫자,깊이,String
        
        return ans;
    }
    
    public static void perm(int num, int depth, String numbers){
        
        if(isPrime(num)){
            set.add(num);
            ans++;
        }
        
        if(depth==numbers.length()){
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                perm(num*10+numbers.charAt(i)-'0',depth+1,numbers);
                isVisited[i]=false;
            }
        }
        
        
    }
    
    public static boolean isPrime(int num){
        
        if(set.contains(num)||num<2){
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