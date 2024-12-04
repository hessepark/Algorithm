import java.util.*;
import java.io.*;

class Solution {
    //각 인덱스에서 붙일 수 있는 거 다 붙여본다.
    
    public static boolean isVisited[];
    public static HashSet<Integer>set;
    public static int answer;
    
    public int solution(String numbers) {
        answer = 0;
        
        isVisited=new boolean[numbers.length()+1];
        set=new HashSet<>();
        
        perm("",0,numbers);//현재 값, 깊이
        
        return answer;
    }
    
    public static void perm(String cur,int depth,String numbers){
        
         if(!cur.equals("")&&isPrime(Integer.parseInt(cur))){
            set.add(Integer.parseInt(cur));
            answer++;
        }
        
        // if(depth==numbers.length()){
        //     return;
        // }
        
        for(int i=0;i<numbers.length();i++){
            if(!isVisited[i]) {
                isVisited[i]=true;
                perm(cur+numbers.charAt(i),depth+1,numbers);
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