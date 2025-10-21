import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        int sum=0;
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max=Math.max(max,arr[i]);
            sum+=arr[i];
        }

        int m = sc.nextInt();

        if(sum<=m){
            System.out.println(max);
            return;
        }

        long result = find(arr, m);

        System.out.println(result);

    }

    public static long find(int[] arr, int m) {

        long l = 0;
        long r = arr.length * 100000;
        long ans=-1;

        while (l <= r) {
            long mid = (l + r) / 2;

            if(calculate(arr,mid)<=m){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }

        }

        return ans;
    }

    public static long calculate(int[] arr,long mid) {

        long sum=0;

        //System.out.println("mid = " + mid);

        for(int i=0;i<arr.length;i++){
            if(mid<=arr[i]){
                sum+=mid;
            }
            else{
                sum+=arr[i];
            }
        }

       // System.out.println("sum = " + sum);

        return sum;

    }

}





