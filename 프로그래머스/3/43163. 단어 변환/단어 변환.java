class Solution { //dfs는 비효율적인듯
    
    public static int ans;
    public static boolean[] isVisited;
    
    public int solution(String begin, String target, String[] words) {
        ans = 0;
        
        isVisited=new boolean[words.length];
        
        dfs(begin,target,words,0);
        
        
        return ans;
    }
    
    public static void dfs(String cur,String target,String[] words,int cnt){
        
        if(cur.equals(target)){
            if(ans==0||cnt<ans){
                ans=cnt;
            }
        }
        
        for(int i=0;i<words.length;i++){
            if(!isVisited[i]&&check(cur,words[i])){
                isVisited[i]=true;
                dfs(words[i],target,words,cnt+1);
                isVisited[i]=false;
            }
        }
        
        
    }
    
    public static boolean check(String a, String b){
        int cnt=0;
        
        for(int i=0;i<a.length();i++){
            
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
            
        }
        
        if(cnt!=1){
            return false;
        }
        
        return true;
        
    }
}