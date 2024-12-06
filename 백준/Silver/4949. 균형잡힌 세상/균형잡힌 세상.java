import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			char arr[]=sc.nextLine().toCharArray();
			
			//System.out.println(Arrays.toString(arr));
			
			if(arr[0]=='.') break;
			
			ArrayDeque<Character>q = new ArrayDeque<>();
			
			String ans="yes";
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='(') {
					q.add(arr[i]);
				}
				else if(arr[i]=='[') {
					q.add(arr[i]);
				}
				
				else if(arr[i]==')') {
					if(q.isEmpty()) {
						ans="no";
						break;
					}
					else if(q.peekLast()=='(') {
						q.pollLast();
					}
					else { //여기 중요 반례: [(].
						ans="no";
						break;
					}
				}
				else if(arr[i]==']') {
					if(q.isEmpty()) {
						ans="no";
						break;
					}
					else if(q.peekLast()=='[') {
						q.pollLast();
					}
					else {  //여기 중요
						ans="no";
						break;
					}
				}
			}
			
			if(!q.isEmpty()) {
				ans="no";
			}
			
			//System.out.println(q);
			
			System.out.println(ans);
			
			
		}
	
		
	}
}