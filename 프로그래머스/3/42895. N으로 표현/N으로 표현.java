import java.util.*;
import java.io.*;

class Solution {
    public int solution(int N, int number) {
        
        HashMap<Integer,HashSet<Integer>> dp = new HashMap<>();
        
        if(N==number){
            return 1;
        }
        
        for(int n=1;n<9;n++){
            String num="";
          
            for(int i=1;i<=n;i++){
                num+=N;
            }
            HashSet<Integer>set = new HashSet<>();
            set.add(Integer.parseInt(num));
            
            if(n==1){
                dp.put(1,set);
                continue;
            }
            
            // 3 (1,2) (2,1)
            for(int i=1;i<n;i++){
                for(int x : dp.get(i)){
                    for(int y: dp.get(n-i)){
                        set.add(x+y);
                        set.add(x-y);
                        set.add(x*y);
                        if(y!=0){
                            set.add(x/y);
                        }
                    }
                }
            }
            
            if(set.contains(number)){
                return n;
            }
            
            dp.put(n,set);
            
        }
        
        return -1;
    }
}