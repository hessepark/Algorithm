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

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        long find=search(arr,m);

        System.out.println(find);
    }

    public static long search(int[] arr, int m) {

        long l =0;
        long r = arr.length*10000;
        long ans=-1;

        while(l<=r) {
            long mid=(l+r)/2;

            //System.out.println("mid = " + mid);

            if(count(arr,mid)<=m){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return ans;
    }

    public static int count(int[] arr,long mid) {

        long tmp=mid;
        int cnt=1;

        for(int i=0;i<arr.length;i++){
            if(mid<arr[i]) return Integer.MAX_VALUE;
            if(tmp-arr[i]<0){
                cnt++;
                tmp=mid;
            }
            tmp-=arr[i];
            //System.out.println("tmp = " + tmp);
        }

        //System.out.println(cnt);

        return cnt;

    }



    //숫자가 더 커지면 늘이고,
    //숫자가 같거나 작으면 갱신 후 줄이기


}





