import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        answer=n-lost.length;
        
        ArrayList<Integer>lo = new ArrayList<>();
        
        for(int i=0;i<lost.length;i++){
            lo.add(lost[i]);
        }
        
        ArrayList<Integer>re = new ArrayList<>();
        
        for(int i=0;i<reserve.length;i++){
            re.add(reserve[i]);
        }
        
        
        System.out.println(lo);
        System.out.println(re);
        
        for(int i=0;i<lo.size();i++){
            for(int j=0;j<re.size();j++){
                if(lo.get(i)==re.get(j)){
                    re.remove(j);
                    lo.remove(i);
                    i--;
                    answer++;
                    break;
                }
                else if(lo.get(i)<re.get(j)){
                    break;
                }
            }
        }
        
        System.out.println(lo);
        System.out.println(re);
        
        for(int i=0;i<lo.size();i++){
            for(int j=0;j<re.size();j++){
                if(lo.get(i)==re.get(j)+1){
                	//System.out.println("빌린 사람:"+lo.get(i)+"빌려준 사람:"+re.get(j));
                    re.remove(j);
                    answer++;
                   
                    break;
                }
                else if(lo.get(i)==re.get(j)-1){
                	//System.out.println("빌린 사람:"+lo.get(i)+"빌려준 사람:"+re.get(j));
                    re.remove(j);
                    answer++;
                    
                    break;
                }
            }
        }
        
        
        return answer;
    }


}
