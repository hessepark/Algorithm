import java.util.*;
import java.io.*;

class Solution {
    
    //dfs로 깊이 들어가보면서 만족하면 전역 ans++;
    
    public static int ans;
    
    public int solution(int[] numbers, int target) {
        ans=0;
        
        dfs(0,0,numbers,target);//현재 값, 깊이
        
        return ans;
    }
    
    public static void dfs(int cur,int depth,int[] numbers,int target){
        
        if(depth==numbers.length){
             if(cur==target){
                  ans++;
                }
            return;
        }
        
     
            dfs(cur+numbers[depth],depth+1,numbers,target); //깊이로 들어가면서
                                                            // +
            dfs(cur-numbers[depth],depth+1,numbers,target); // - 모두 해봐야함
        
        
        
        //   for(int i=0;i<numbers.length;i++){ 처음에 잠깐 이렇게 했는데 이러면 처음 예시에서 idx:0,0,0이 합쳐져서 3됨
        //     dfs(cur+numbers[i],depth+1,numbers,target);
        //     dfs(cur-numbers[i],depth+1,numbers,target);
        // }
    }
    
}