import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();

        int n = sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                set.add(arr[i]+arr[j]);
            }
        }

        //System.out.println(set);

        int ans=-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(set.contains(arr[i]-arr[j])){
                    ans=Math.max(ans,arr[i]);
                }
            }
        }

        System.out.println(ans);


    }



}





