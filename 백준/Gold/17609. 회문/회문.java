import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            char str[] = sc.next().toCharArray();

            int l = 0;
            int r = str.length - 1;
            int ans = 0;

            while (l <= r) { //l<r해도 될듯
                if (str[l] != str[r]) {
                    if (isPalindrome(str, l + 1, r) || isPalindrome(str, l, r - 1)) {
                        ans = 1;
                    } else {
                        ans = 2;
                    }
                    break; //break없어도 될듯
                }
                l++;
                r--;
            }

            System.out.println(ans);

        }

    }

    private static boolean isPalindrome(char[] str, int l, int r) {

        while (l <= r) {
            if (str[l] != str[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }

}