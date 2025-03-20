import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
//         ArrayList<Integer> list = new ArrayList<>();
        
//         for(int i=0;i<people.length;i++){
//             list.add(people[i]);
//         }
        
//         Collections.sort(list,(o1,o2)->Integer.compare(o2,o1));

        Arrays.sort(people);
        
//         while(list.size()!=0){
//             int sum=list.get(0);
//             for(int i=1;i<list.size();i++){
//                 if(sum+list.get(i)<=limit){
//                     list.remove(i);
//                     break;
//                 }
//             }
//             list.remove(0);
//             answer++;
//         }
        int start=0;
        int end=people.length-1;
        
        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
            }
            end--;
            answer++;
            
        }
        
        return answer;
    }
}