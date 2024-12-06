import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char str[]=sc.next().toCharArray();
		
		ArrayDeque<Character>q = new ArrayDeque<>();
		
		int result=0;
		
		for(int i=0;i<str.length;i++) {
			if(str[i]=='(') {
				q.add(str[i]);
			}
			else {
				q.pollLast();
				if(str[i-1]=='(') {
					result+=q.size();
				}
				else {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
	}
}