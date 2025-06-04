import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static int dr[] = {-1, 0, 1, 0};
    public static int dc[] = {0, 1, 0, -1};
    public static int visited[][][];
    public static char map[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int answer=0;

        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new int[n + 1][m + 1][2];
        map = new char[n + 1][m + 1];

        sc.nextLine();

        for (int i = 1; i < n + 1; i++) {
            String line = sc.nextLine();
            for(int j=1;j<m+1;j++){
                map[i][j]=line.charAt(j-1);
            }
        }

        ArrayDeque<Pos> q = new ArrayDeque<>();
        visited[1][1][0] = 1;
        q.add(new Pos(1, 1, 0));

        while (!q.isEmpty()) {

            Pos now = q.poll();

            if(now.r==n&&now.c==m){
                System.out.println(visited[now.r][now.c][now.idx]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr <= 0 || nc <= 0 || nr > n || nc > m) {
                    continue;
                }

                if (visited[nr][nc][now.idx] == 0 && map[nr][nc] == '0') {
                    q.add(new Pos(nr, nc, now.idx));
                    visited[nr][nc][now.idx] = visited[now.r][now.c][now.idx] + 1;
                }
                else if(now.idx==0&&map[nr][nc]=='1'){
                    q.add(new Pos(nr,nc,now.idx+1));
                    visited[nr][nc][now.idx+1]=visited[now.r][now.c][now.idx]+1;
                }

            }

        }

        System.out.println(-1);



    }
}

class Pos {
    int r;
    int c;
    int idx;

    public Pos(int r, int c, int idx) {
        this.r = r;
        this.c = c;
        this.idx = idx;
    }
}