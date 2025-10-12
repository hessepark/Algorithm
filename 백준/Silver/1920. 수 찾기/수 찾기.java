import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        int m = sc.nextInt();

        while(m-->0){
            int target =sc.nextInt();
            if(isExist(arr,target)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }


    }

    public static boolean isExist(int[] arr,int target){

        int l = 0;
        int r= arr.length-1;

        while(l<=r){
            int m = (l+r)/2;
            if(arr[m]<target){
                l=m+1;
            }
            else if(arr[m]>target){
                r=m-1;
            }
            else{
                return true;
            }
        }

        return false;


    }


}
