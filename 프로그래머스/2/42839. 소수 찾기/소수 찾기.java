import java.util.*;
import java.io.*;

//11과 011은 같다 ->HashSet필요하구나
//모든 순열(순서가 부여된 임의의 집합) 만들어봐야하구나 permutation ->어떤 매개변수?
//값 중복 사용불가->방문여부 체크하는 배열 필요하다.

class Solution {
    
    public static HashSet<Integer>set;
    public static boolean isVisited[];
    public static int ans; //전역적으로 값 증가
    
    public int solution(String numbers) {
        ans=0;
        
        set = new HashSet<>();
        isVisited=new boolean[numbers.length()]; //어차피 false로 계속 처리해줄 거니 한 번만 초기화
        
        for(int i=1;i<=numbers.length();i++){ //모든 길이 다 체크
        
            perm("",numbers,i); //현재 어떤 조합인지, String ,목표 깊이
            
        }
        
        return ans;
    }
    
    public static void perm(String current,String numbers,int depth){

        if(current.length()==depth){

            if(isPrime(Integer.parseInt(current))) {//set 체크도 Prime내부에서 해주자
                set.add(Integer.parseInt(current));
                ans++;    
                
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
        
        if(set.contains(num)){ //이미 포함하고 있으면 중복증가 방지
            return false;
        }
        
        if(num<2){ //값이 0이나 1
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