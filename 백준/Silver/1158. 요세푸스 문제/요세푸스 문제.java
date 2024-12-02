import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Integer>list = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		int currentIndex=0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(list.size()!=0) {
			currentIndex=(currentIndex+k-1)%list.size();
			sb.append(list.remove(currentIndex));
			
			if(list.size()!=0) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
		
	}
}