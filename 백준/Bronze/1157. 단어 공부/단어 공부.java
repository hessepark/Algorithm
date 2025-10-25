import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		str=str.toLowerCase();
		
		//System.out.println(str);
		
		int cnt[]=new int[26];
		
		int max =Integer.MIN_VALUE;
		
		for(int i=0;i<str.length();i++) {
			max=Math.max(max, ++cnt[str.charAt(i)-'a']);
		}
		
		int count=0;
		int idx=-1;
		
		for(int i=0;i<cnt.length;i++) {
			if(max==cnt[i]) {
				idx=i;
				count++;
			}
			if(count>=2) break;
		}
		
		System.out.println(count>=2?'?':(char)(idx+'A'));
	}
	


}