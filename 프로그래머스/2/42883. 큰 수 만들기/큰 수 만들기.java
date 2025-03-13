class Solution {
    public static String solution(String number, int k) {
        //String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        int num=number.length()-(number.length()-k-1); //5
        
        //String parse=number.substring(0,num); // 41772
        
        //System.out.println(parse);
        
        int maxIndex=0;
       
        for(int i=1;i<=number.length()-k;i++){
        	int max=Integer.MIN_VALUE;
            for(int j=maxIndex;j<num;j++){
                if(max<number.charAt(j)-'0'){
                    maxIndex=j;
                    max=number.charAt(j)-'0';
                }
            }
            
            //answer+=number.charAt(maxIndex);
            sb.append(max);
            
            if(sb.length()==number.length()-k)break;
            
            ++maxIndex;
            ++num;
            
            //System.out.println(parse);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	String number="4177252841";
    	System.out.println(solution(number,4));;
    }
}