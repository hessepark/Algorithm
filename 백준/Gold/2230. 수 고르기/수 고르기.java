import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int minDiff=Integer.MAX_VALUE;
        int idx=0;

        for(int i=0;i<n;i++) {

            while(idx<n-1&&arr[idx]-arr[i]<m){
                idx++;
            }

            if(arr[idx]-arr[i]>=m)
            minDiff=Math.min(minDiff,arr[idx]-arr[i]);

        }

        System.out.println(minDiff);

    }

}





