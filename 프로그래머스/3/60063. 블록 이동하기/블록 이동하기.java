import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][2];
        Queue<Robot> q = new ArrayDeque<>();

        Pos start1 = new Pos(0, 0);
        Pos start2 = new Pos(0, 1);
        q.add(new Robot(start1, start2, 0));
        visited[0][0][0] = true;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            Robot ro = q.poll();
            Pos p1 = ro.p1, p2 = ro.p2;

            if ((p1.r == n - 1 && p1.c == n - 1) || (p2.r == n - 1 && p2.c == n - 1)) {
                return ro.t;
            }

            // 평행 이동
            for (int i = 0; i < 4; i++) {
                int nr1 = p1.r + dr[i], nc1 = p1.c + dc[i];
                int nr2 = p2.r + dr[i], nc2 = p2.c + dc[i];
                if (isValid(nr1, nc1, n) && isValid(nr2, nc2, n) &&
                        board[nr1][nc1] == 0 && board[nr2][nc2] == 0) {
                    int dir = (nr1 == nr2) ? 0 : 1;
                    int baseR = Math.min(nr1, nr2);
                    int baseC = Math.min(nc1, nc2);
                    if (!visited[baseR][baseC][dir]) {
                        visited[baseR][baseC][dir] = true;
                        q.add(new Robot(new Pos(nr1, nc1), new Pos(nr2, nc2), ro.t + 1));
                    }
                }
            }

            // 회전
            if (p1.r == p2.r) { // 가로
                for (int d : new int[]{-1, 1}) {
                    if (isValid(p1.r + d, p1.c, n) && isValid(p2.r + d, p2.c, n) &&
                            board[p1.r + d][p1.c] == 0 && board[p2.r + d][p2.c] == 0) {
                        if (!visited[Math.min(p1.r, p1.r + d)][p1.c][1]) {
                            visited[Math.min(p1.r, p1.r + d)][p1.c][1] = true;
                            q.add(new Robot(p1, new Pos(p1.r + d, p1.c), ro.t + 1));
                        }
                        if (!visited[Math.min(p2.r, p2.r + d)][p2.c][1]) {
                            visited[Math.min(p2.r, p2.r + d)][p2.c][1] = true;
                            q.add(new Robot(p2, new Pos(p2.r + d, p2.c), ro.t + 1));
                        }
                    }
                }
            } else { // 세로
                for (int d : new int[]{-1, 1}) {
                    if (isValid(p1.r, p1.c + d, n) && isValid(p2.r, p2.c + d, n) &&
                            board[p1.r][p1.c + d] == 0 && board[p2.r][p2.c + d] == 0) {
                        if (!visited[p1.r][Math.min(p1.c, p1.c + d)][0]) {
                            visited[p1.r][Math.min(p1.c, p1.c + d)][0] = true;
                            q.add(new Robot(p1, new Pos(p1.r, p1.c + d), ro.t + 1));
                        }
                        if (!visited[p2.r][Math.min(p2.c, p2.c + d)][0]) {
                            visited[p2.r][Math.min(p2.c, p2.c + d)][0] = true;
                            q.add(new Robot(p2, new Pos(p2.r, p2.c + d), ro.t + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }

    boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}

class Pos {
    int r, c;
    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Robot {
    Pos p1, p2;
    int t;
    public Robot(Pos p1, Pos p2, int t) {
        this.p1 = p1;
        this.p2 = p2;
        this.t = t;
    }
}
