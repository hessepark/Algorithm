import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int p = sc.nextInt();

        String word = sc.next();

        int minCount[]=new int[4];

        for(int i=0;i<4;i++){
            minCount[i] = sc.nextInt();
        }

        int alphaCount[]=new int[4];

        for(int i=0;i<p-1;i++){
            alphaCount[baseToIndex(word.charAt(i))]++;
        }

        int cnt=0;

        for(int i=p-1;i<s;i++){
            alphaCount[baseToIndex(word.charAt(i))]++;
            if(isValid(alphaCount,minCount)){
                cnt++;
            }
            alphaCount[baseToIndex(word.charAt(i-p+1))]--;
        }

        System.out.println(cnt);


    }

    private static boolean isValid(int[] alphaCount, int[] minCount) {

        for(int i=0;i<4;i++){
            if(alphaCount[i]<minCount[i]) return false;
        }

        return true;

    }

    private static int baseToIndex(char c) {
        if(c=='A'){
            return 0;
        }
        else if(c=='C'){
            return 1;
        }
        else if(c=='G'){
            return 2;
        }
        else{
            return 3;
        }
    }


}





