import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; // 결과를 담을 배열
        HashMap<Character, Integer> map = new HashMap<>(); // 문자별 가장 최근 인덱스를 저장

       for(int i=0; i<s.length();i++){
            char a = s.charAt(i);
            int idx=-1;
           for(int j=0;j<i;j++){
               char b = s.charAt(j);
               
               if(a==b){
                   idx=j;
               }
           }
           if(idx!=-1){
               answer[i]=i-idx;
           }
           else{
               answer[i]=-1;
           }
       }

        return answer;
    }
}
