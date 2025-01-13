import java.util.*;
import java.io.*;

class Solution {
    
    public static HashSet<Integer>set;
    public static int ans;
    public static boolean isVisited[];
    
    public int solution(String numbers) {
        ans = 0;
        
        set = new HashSet<>();
        isVisited = new boolean[numbers.length()];
        
        perm(0,0,numbers); //현재 값, 깊이
        
        return ans;
    }
    
    public static void perm(int cur,int depth,String numbers){
        
        if(isPrime(cur)&&cur>=2){
            set.add(cur);
            ans++;
        }
        
        if(depth==numbers.length()){ //이게 없으면 012 다 차고도 또 012 한 번 더 봐야함
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                perm(cur*10+numbers.charAt(i)-'0',depth+1,numbers);
                isVisited[i]=false;
            }
        }
        
    }
    
    public static boolean isPrime(int num){
        
        if(set.contains(num)){
            return false;
        }
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

}