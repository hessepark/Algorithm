import java.util.*;
import java.io.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int pT=StrToInt(play_time);
        int aT=StrToInt(adv_time);
        
        System.out.println(pT+" "+aT);
        
        long dp[]=new long[pT+1];
        
        for(int i=0;i<logs.length;i++) {
            String[] t=logs[i].split("-");
            
            int t1 = StrToInt(t[0]);
            int t2 = StrToInt(t[1]);
            
            dp[t1]+=1;
            dp[t2]-=1;
        }
        
        //구간별 시청자수
        for(int i=1;i<=pT;i++){
            dp[i]+=dp[i-1];
        }
        
        //구간별 누적 수
        for(int i=1;i<=pT;i++){
            dp[i]+=dp[i-1];
        }
        
        long max=dp[aT-1];
        int startTime=0;
        
        for(int i=0;i<=pT-aT;i++){
            if(dp[aT+i]-dp[i]>max){
                max=dp[aT+i]-dp[i];
                startTime=i+1;
            }
        }
        
        return LongToStr(startTime);
    }
    
    public static int StrToInt(String time) {
        
        String word[]=time.split(":");
        
        int hour=Integer.parseInt(word[0]);
        int minute=Integer.parseInt(word[1]);
        int second=Integer.parseInt(word[2]);
        
        return hour*3600+minute*60+second;  
        
    }
    
    public static String LongToStr(long time){
        
        String hour = time/3600+"";
        time%=3600;
        
        if(hour.length()==1) {
            hour="0"+hour;
        }
        
        String minute = time/60+"";
        time%=60;
        if(minute.length()==1) {
            minute="0"+minute;
        }
        
        String second = time+"";
        if(second.length()==1) {
            second="0"+second;
        }
        
        return hour+":"+minute+":"+second;
        
        
    }
    
}