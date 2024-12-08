import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		//char arr[] = str.toCharArray(); 이렇게 해줘도 됨
		
		ArrayDeque<Character> q = new ArrayDeque<>();
		
		int ans=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				q.add('(');
			}
			else {
				q.poll();
				if(str.charAt(i-1)=='(') {
					ans+=q.size();
				}
				else {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}
}