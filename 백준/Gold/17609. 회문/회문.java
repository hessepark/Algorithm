import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0;i<n;i++) {

            String word = sc.next();

            int l = 0;
            int r = word.length()-1;
            int cnt=0;

            while(l<r) {
                if(word.charAt(l)==word.charAt(r)){
                    l++;
                    r--;
                }
                else{
                    if(word.charAt(l+1)==word.charAt(r)){
                        l++;
                    }
                    else{
                        r--;
                    }
                    cnt++;
                }
            }

            l = 0;
            r = word.length()-1;
            int cnt1=0;

            while(l<r) {
                if(word.charAt(l)==word.charAt(r)){
                    l++;
                    r--;
                }
                else{
                    if(word.charAt(r-1)==word.charAt(l)){
                        r--;
                    }
                    else{
                        l++;
                    }
                    cnt1++;
                }
            }

            if(cnt==0) {
                System.out.println(0);
            }
            else if (cnt==1||cnt1==1) {
                System.out.println(1);
            }
            else {
                System.out.println(2);
            }

        }





    }

}





