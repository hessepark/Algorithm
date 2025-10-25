import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String time1[]=sc.next().split(":");
		String time2[]=sc.next().split(":");
		
		int timeSum1=Integer.parseInt(time1[0])*3600+Integer.parseInt(time1[1])*60+Integer.parseInt(time1[2]);
		int timeSum2=Integer.parseInt(time2[0])*3600+Integer.parseInt(time2[1])*60+Integer.parseInt(time2[2]);
			
		int ans=timeSum2-timeSum1;
		
		if(ans<=0) {
			ans+=24*3600;
		}
		
		int t=ans/3600;
		int m=ans%3600/60;
		int s=ans%60;
		
		//System.out.println(t+" "+m+" "+s);
		
		System.out.printf("%02d:%02d:%02d",t,m,s);
		

	}
	


}