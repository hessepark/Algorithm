

import java.io.*;
import java.util.*;

public class Main {

    public static int dr[] = {-1, 0, 1, 0};
    public static int dc[] = {0, 1, 0, -1};
    public static int visited[][];
    public static int isWall[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        visited = new int[n + 1][n + 1];
        isWall = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                isWall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());

        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());
            people.add(new Person(sR, sC, eR, eC));
        }

        Collections.sort(people, (o1, o2) -> {
            if (o1.sr != o2.sr) return Integer.compare(o1.sr, o2.sr);
            return Integer.compare(o1.sc, o2.sc);
        });

        int x = startR;
        int y = startC;

        while (!people.isEmpty()) {

            ArrayDeque<Pos> q = new ArrayDeque<>();
            int[][] visited = new int[n + 1][n + 1];
            q.add(new Pos(x, y, fuel));
            visited[x][y] = 1;

            while (!q.isEmpty()) {
                Pos now = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = now.r + dr[k];
                    int nc = now.c + dc[k];

                    if (nr <= 0 || nc <= 0 || nr > n || nc > n || isWall[nr][nc] == 1) continue;

                    if (visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        q.add(new Pos(nr, nc, now.fuel - 1));
                    }
                }
            }

            int dist = visited[people.get(0).sr][people.get(0).sc];
            int minIdx = 0;

            for (int i = 1; i < people.size(); i++) {
                int curDist = visited[people.get(i).sr][people.get(i).sc];
                if (curDist == 0) continue;

                if (curDist < dist || 
                    (curDist == dist && (
                        people.get(i).sr < people.get(minIdx).sr || 
                        (people.get(i).sr == people.get(minIdx).sr && people.get(i).sc < people.get(minIdx).sc)
                    ))) {
                    dist = curDist;
                    minIdx = i;
                }
            }

            if (dist == 0 || fuel - (dist - 1) < 0) {
                System.out.println(-1);
                return;
            }

            fuel -= (dist - 1);

            visited = new int[n + 1][n + 1];
            x = people.get(minIdx).sr;
            y = people.get(minIdx).sc;

            q = new ArrayDeque<>();
            q.add(new Pos(x, y, fuel));
            visited[x][y] = 1;

            boolean arrived = false;

            while (!q.isEmpty()) {
                Pos now = q.poll();

                if (now.r == people.get(minIdx).er && now.c == people.get(minIdx).ec) {
                    if (now.fuel < 0) {
                        System.out.println(-1);
                        return;
                    }
                    fuel = now.fuel + (visited[now.r][now.c] - 1) * 2;
                    x = now.r;
                    y = now.c;
                    people.remove(minIdx);
                    arrived = true;
                    break;
                }

                if (now.fuel <= 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = now.r + dr[k];
                    int nc = now.c + dc[k];

                    if (nr <= 0 || nc <= 0 || nr > n || nc > n || isWall[nr][nc] == 1) continue;

                    if (visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        q.add(new Pos(nr, nc, now.fuel - 1));
                    }
                }
            }

            if (!arrived) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(fuel);
    }
}

class Pos {
    int r;
    int c;
    int fuel;

    public Pos(int r, int c, int fuel) {
        this.r = r;
        this.c = c;
        this.fuel = fuel;
    }
}

class Person {
    int sr;
    int sc;
    int er;
    int ec;

    public Person(int sr, int sc, int er, int ec) {
        this.sr = sr;
        this.sc = sc;
        this.er = er;
        this.ec = ec;
    }
}
