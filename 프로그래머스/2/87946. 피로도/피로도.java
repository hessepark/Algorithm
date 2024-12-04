class Solution {
    
    public static boolean isVisited[];
    public static int max;
    
    public int solution(int k, int[][] dungeons) {
      
        max = Integer.MIN_VALUE;
        isVisited=new boolean[dungeons.length+1];
        
        perm(k,0,dungeons);//피로도,깊이
        
        return max;
    }
    
    public static void perm(int cur,int depth,int[][] dungeons) {
        
        max=Math.max(max,depth);
        
        if(depth==dungeons.length){
            return;
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(cur>=dungeons[i][0]&&!isVisited[i]){
                isVisited[i]=true;
               //System.out.println(i);
                perm(cur-dungeons[i][1],depth+1,dungeons);
                isVisited[i]=false;
            }
        }
        
        
    }
    
}