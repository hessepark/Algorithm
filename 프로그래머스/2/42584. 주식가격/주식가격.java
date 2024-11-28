class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length-1;i++){ //마지막 값을 제외하고 본다.
            int idx=1; //무조건 1은 처음에 할당해줌
            for(int j=i+1;j<prices.length-1;j++){
                // if(prices[i]<=prices[j]){
                //     idx++;
                // }
                // else{
                //     break;
                // }
                if(prices[i]>prices[j]){
                    break;
                }
                idx++;
                
            }
            answer[i]=idx;
        }
        
        answer[prices.length-1]=0; //마지막 값은 무조건 0
        
        return answer;
    }
}