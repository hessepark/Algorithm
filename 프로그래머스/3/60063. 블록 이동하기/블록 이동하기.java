import java.util.*;
import java.io.*;

class Solution {

    public static int dr[] = {-1, 0, 1, 0};
    public static int dc[] = {0, 1, 0, -1};
    public static int visited[][][]; // [row][col][orientation: 0=horizontal, 1=vertical]

    public int solution(int[][] board) {
        int n = board.length;

        visited = new int[n + 1][n + 1][2];
        ArrayDeque<Robot> q = new ArrayDeque<>();

        q.add(new Robot(new Pos(1, 1), new Pos(1, 2), 0));
        visited[1][1][0] = 1;

        while (!q.isEmpty()) {
            Robot now = q.poll();
            Pos p1 = now.p1;
            Pos p2 = now.p2;

            // 도착
            if ((p1.r == n && p1.c == n) || (p2.r == n && p2.c == n)) {
                return visited[p1.r][p1.c][now.vertical] - 1;
            }

            int curTime = visited[p1.r][p1.c][now.vertical];

            // 4방향 이동
            for (int k = 0; k < 4; k++) {
                int nr1 = p1.r + dr[k], nc1 = p1.c + dc[k];
                int nr2 = p2.r + dr[k], nc2 = p2.c + dc[k];

                if (isValid(nr1, nc1, n) && isValid(nr2, nc2, n)
                        && board[nr1 - 1][nc1 - 1] == 0 && board[nr2 - 1][nc2 - 1] == 0) {

                    Robot moved = new Robot(new Pos(nr1, nc1), new Pos(nr2, nc2), now.vertical);
                    Pos base = moved.p1;
                    if (visited[base.r][base.c][moved.vertical] == 0) {
                        visited[base.r][base.c][moved.vertical] = curTime + 1;
                        q.add(moved);
                    }
                }
            }

            // 회전 (수평 → 수직)
            if (p1.r == p2.r) {
                for (int d : new int[]{-1, 1}) {
                    if (isValid(p1.r + d, p1.c, n) && isValid(p2.r + d, p2.c, n)
                            && board[p1.r + d - 1][p1.c - 1] == 0 && board[p2.r + d - 1][p2.c - 1] == 0) {

                        Robot r1 = new Robot(p1, new Pos(p1.r + d, p1.c), 1);
                        Robot r2 = new Robot(p2, new Pos(p2.r + d, p2.c), 1);

                        if (visited[r1.p1.r][r1.p1.c][1] == 0) {
                            visited[r1.p1.r][r1.p1.c][1] = curTime + 1;
                            q.add(r1);
                        }
                        if (visited[r2.p1.r][r2.p1.c][1] == 0) {
                            visited[r2.p1.r][r2.p1.c][1] = curTime + 1;
                            q.add(r2);
                        }
                    }
                }
            }
            // 회전 (수직 → 수평)
            else {
                for (int d : new int[]{-1, 1}) {
                    if (isValid(p1.r, p1.c + d, n) && isValid(p2.r, p2.c + d, n)
                            && board[p1.r - 1][p1.c + d - 1] == 0 && board[p2.r - 1][p2.c + d - 1] == 0) {

                        Robot r1 = new Robot(p1, new Pos(p1.r, p1.c + d), 0);
                        Robot r2 = new Robot(p2, new Pos(p2.r, p2.c + d), 0);

                        if (visited[r1.p1.r][r1.p1.c][0] == 0) {
                            visited[r1.p1.r][r1.p1.c][0] = curTime + 1;
                            q.add(r1);
                        }
                        if (visited[r2.p1.r][r2.p1.c][0] == 0) {
                            visited[r2.p1.r][r2.p1.c][0] = curTime + 1;
                            q.add(r2);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int r, int c, int n) {
        return r > 0 && r <= n && c > 0 && c <= n;
    }
}

class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Robot {
    Pos p1;
    Pos p2;
    int vertical; // 0: 수평, 1: 수직

    public Robot(Pos a, Pos b, int vertical) {
        if (a.r < b.r || (a.r == b.r && a.c < b.c)) {
            this.p1 = a;
            this.p2 = b;
        } else {
            this.p1 = b;
            this.p2 = a;
        }
        this.vertical = vertical;
    }
}
