import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static int max = 0;
    public static int dr[] = {-1, 0, 1, 0};
    public static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        max = Integer.MIN_VALUE;

        int[][] arr = new int[n][m];

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    list.add(new int[]{i, j});
                    //System.out.println("추가함"+ i+" "+j);
                }
            }
        }


        dfs(arr, 0, 0, 0, list);

        System.out.println(max);
    }

    public static void dfs(int[][] arr, int depth, int r, int c, ArrayList<int[]> list) {

        if (depth == 3) {

            ArrayDeque<int[]> q = new ArrayDeque<>();

            for(int [] l:list) {
                q.add(l);
            }

            int count = 0;

            boolean visited[][] = new boolean[arr.length][arr[0].length];

            while (!q.isEmpty()) {

                int[] now = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = now[0] + dr[k];
                    int nc = now[1] + dc[k];

                    if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr[0].length)
                        continue;

                    if (!visited[nr][nc]&&arr[nr][nc]==0) {
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }


            }


            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!visited[i][j]&&arr[i][j]==0) {
                        count++;
                    }
                }
            }

//            System.out.println(count);
//
//            for(int i=0;i<arr.length;i++){
//                for (int j=0;j<arr[0].length;j++){
//                    System.out.print(arr[i][j]);
//                }
//                System.out.println();
//            }
//
//            System.out.println();
//
//            for(int i=0;i<arr.length;i++){
//                for (int j=0;j<arr[0].length;j++){
//                    System.out.print(visited[i][j]);
//                }
//                System.out.println();
//            }

            max = Math.max(max, count);
            return;

        }

        for (int i = r; i < arr.length; i++) {
            for (int j = (i==r?c:0); j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(arr, depth+1, i, j, list);
                    arr[i][j] = 0;
                }
            }
        }

    }
}