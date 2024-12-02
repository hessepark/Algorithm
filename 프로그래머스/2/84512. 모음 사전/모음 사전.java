import java.io.*;
import java.util.*;

class Solution { // 0,00,...00000,00001 순서대로 만들어놓고 계산
    
    public static HashMap<String,Integer> map;
    public static int cnt;
    
    public int solution(String word) {
        int answer = 0;
        
        cnt=1;
        map = new HashMap<>();
        
        make("",0);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<word.length();i++) {
            if(word.charAt(i)=='A'){
                sb.append(0);
            }
            else if(word.charAt(i)=='E'){
                sb.append(1);
            }
            else if(word.charAt(i)=='I'){
                sb.append(2);
            }
            else if(word.charAt(i)=='O'){
                sb.append(3);
            }
            else{
                sb.append(4);
            }
        }
        
        //System.out.println(sb);
        
        answer = map.get(sb.toString());
        
        return answer;
    }
    
    public static void make(String cur,int depth){
        
        if(depth==5){
            return;
        }
        
        for(int i=0;i<5;i++){
            map.put(cur+Integer.toString(i),cnt);
            //System.out.println(cur+Integer.toString(i));
            cnt++;
            make(cur+Integer.toString(i),depth+1);
        }
        
        
    
    }
}