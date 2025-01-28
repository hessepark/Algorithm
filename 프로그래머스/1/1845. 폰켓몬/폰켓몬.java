import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        //해시맵 크기 < nums/2면 해시맵 크기
        //해시맵 크기 > nums/2면 nums/2
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        if(map.size()<nums.length/2){
            answer=map.size();
        }
        else{
            answer=nums.length/2;
        }
        
        
        return answer;
    }
}