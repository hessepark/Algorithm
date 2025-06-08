
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


        Collections.sort(people,(o1,o2)->{
            if(o1.sr!=o2.sr){
                return Integer.compare(o1.sr,o2.sr);
            }
            else if(o1.sc!=o2.sc){
                return Integer.compare(o1.sc,o2.sc);
            }
            else{
                return 0;
            }
        });

        int x = startR;
        int y = startC;
        while(!people.isEmpty()){

            ArrayDeque<Pos>q = new ArrayDeque<>();
            int[][]visited=new int[n+1][n+1];
            q.add(new Pos(x,y,fuel));
            visited[x][y]=1;

            boolean arrived = false;

           while(!q.isEmpty()){ //현재 기준 퍼트리기 (매번 최소 거리 찾기 위함)

                Pos now= q.poll();

                for(int k=0;k<4;k++){
                    int nr=dr[k]+now.r;
                    int nc=dc[k]+now.c;

                    if(nr<=0||nc<=0||nr>n||nc>n||isWall[nr][nc]==1){
                        continue;
                    }

                    if(visited[nr][nc]==0){
                        visited[nr][nc]=visited[now.r][now.c]+1;
                        q.add(new Pos(nr,nc,now.fuel-1));
                    }

                }
            }

           //최소 거리, 인덱스 찾기
           int dist=visited[people.get(0).sr][people.get(0).sc];
           int minIdx=0;

           for(int i=1;i<people.size();i++){
               if(visited[people.get(i).sr][people.get(i).sc]<dist){
                   dist=visited[people.get(i).sr][people.get(i).sc];
                   minIdx=i;
               }
           }

           //출발 지점 연료량 계산
           if(fuel-(dist-1)<0||dist==0){ //데리러 못가도 return
               System.out.println(-1);
               return;
           }
           fuel -=(dist-1);
            //System.out.println("출발지 도착:"+fuel);

           //도착 지점까지 보내기
           visited=new int[n+1][n+1];
           x=people.get(minIdx).sr;
           y=people.get(minIdx).sc;

           q.add(new Pos(x,y,fuel));
           visited[x][y]=1;

           while(!q.isEmpty()){

               Pos now = q.poll();

               if(now.r==people.get(minIdx).er&&now.c==people.get(minIdx).ec){
                   if(now.fuel<0){
                       System.out.println(-1);
                       return;
                   }
                   fuel=now.fuel+(visited[now.r][now.c]-1)*2;
                   x=people.get(minIdx).er;
                   y=people.get(minIdx).ec;
                   people.remove(minIdx);
                   //System.out.println("도착지 도착:"+fuel);
                   arrived = true;
                   break;
               }

               for(int k=0;k<4;k++){
                   int nr= now.r+dr[k];
                   int nc= now.c+dc[k];

                   if(nr<=0||nc<=0||nr>n||nc>n||isWall[nr][nc]==1){
                       continue;
                   }

                   if(visited[nr][nc]==0){
                       q.add(new Pos(nr,nc,now.fuel-1));
                       visited[nr][nc]=visited[now.r][now.c]+1;
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

    Person(int sr, int sc, int er, int ec) {
        this.sr = sr;
        this.sc = sc;
        this.er = er;
        this.ec = ec;
    }
}