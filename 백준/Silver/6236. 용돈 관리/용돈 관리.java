import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        long k = findK(arr, m);

        System.out.println(k);


    }

    public static long findK(int[] arr, int m) {

        long l = Arrays.stream(arr).max().getAsInt();;
        long r = 10000000000L;
        long ans = -1;

        while (l <= r) {
            long mid = (l + r) / 2;
           //System.out.println("l출력: " + l + ", r출력: " + r);

            //System.out.println("mid출력: " + mid);
            long tmp = mid;

            int cnt = 1;


            for (int i = 0; i < arr.length; i++) {

                if (mid - arr[i] < 0) {
                    cnt++;
                    mid = tmp;
                }
                mid -= arr[i];
            }

            //System.out.println("cnt 출력:" + cnt + ", mid 출력: " + tmp);

            if (cnt > m) {
                l = tmp + 1;
            } else {
                ans = tmp;
                r = tmp - 1;
            }

        }

        return ans;

    }

    //숫자가 더 커지면 늘이고,
    //숫자가 같거나 작으면 갱신 후 줄이기


}





