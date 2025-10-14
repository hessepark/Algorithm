import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        //System.out.println("arr = " + Arrays.toString(arr));

        int sumAbs = Math.abs(arr[0]+arr[1]);

        int ans[]={arr[0],arr[1]};

        for(int i=0;i<n-1;i++){
            int pairValue=binarySearch(i+1,n-1,arr,arr[i]);

            int pairAbs=Math.abs(arr[i]+pairValue);
            if(sumAbs>pairAbs){
                sumAbs=pairAbs;
                ans[0]=arr[i];
                ans[1]=pairValue;
            }

        }

        bw.write(ans[0]+" "+ans[1]+"\n");

        bw.flush();

    }

    private static int binarySearch(int l, int r, int[] arr, int value) {

        int optAbs=2000000000;
        int pairValue=0;
        

        while(l<=r){
            int m = (l+r)/2;

            int sum=value+arr[m];
            int sumAbs=Math.abs(sum);
            if(sumAbs<optAbs){
                optAbs=sumAbs;
                pairValue=arr[m];
            }

            if(sum<0){
                l=m+1;
            }
            else if(sum>0){
                r=m-1;
            }
            else{
                return arr[m];
            }

        }

        return pairValue;

    }


}





