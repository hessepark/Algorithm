import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int cnt[]=new int[26];
		
		for(int i=0;i<a.length();i++) {
			cnt[a.charAt(i)-'a']++;
		}
		
		for(int i=0;i<b.length();i++) {
			cnt[b.charAt(i)-'a']--;
		}
		
		int ans=0;
		
		for(int i=0;i<cnt.length;i++) {
			ans+=Math.abs(cnt[i]);
		}
		
		System.out.println(ans);
		
	
	}
	

}