

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static char grid[][];
    public static int dr[]={-1,0,1,0};
    public static int dc[]={0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine();

        grid=new char[n][m];

        for(int i=0;i<n;i++){
            grid[i]=sc.nextLine().toCharArray();
        }

        System.out.println(bfs(grid));
    }

    public static int[] move(int r,int c,int dir){

        int nr=r;
        int nc=c;

        while(true){

            nr+=dr[dir];
            nc+=dc[dir];
            if(grid[nr][nc]=='#'){
                nr -=dr[dir];
                nc -=dc[dir];
                break;
            }
            if(grid[nr][nc]=='O'){
                break;
            }

        }

        return new int[] {nr,nc};

    }


    public static int bfs(char[][] grid){

        int rr=0;int rc=0; int br=0; int bc=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='R'){
                    rr=i;
                    rc=j;
                }
                if(grid[i][j]=='B'){
                    br=i;
                    bc=j;
                }
            }
        }

        ArrayDeque<State>q = new ArrayDeque<>();
        HashSet<String>set = new HashSet<>();
        State state = new State(rr,rc,br,bc,0);
        q.add(state);
        set.add(state.toKey());

        while(!q.isEmpty()){

            State now = q.poll();

            if(now.cnt>10) return 0;

            if(grid[now.rr][now.rc]=='O') return 1;

            //다음 상태 예약

            for(int k=0;k<4;k++){

                int[] nextBlue = move(now.br,now.bc,k);
                int[] nextRed = move(now.rr,now.rc,k);

                if(grid[nextBlue[0]][nextBlue[1]]=='O') continue;

                //만약 red,blue 위치 같으면 조정
                if (nextRed[0]==nextBlue[0]&&nextRed[1]==nextBlue[1]){
                   int redDist = Math.abs(now.rr-nextRed[0])+Math.abs(now.rc-nextRed[1]);
                   int blueDist = Math.abs(now.br-nextBlue[0])+Math.abs(now.bc-nextBlue[1]);

                   if(redDist>blueDist){
                       nextRed[0]-=dr[k];
                       nextRed[1]-=dc[k];
                   }
                   else{
                       nextBlue[0]-=dr[k];
                       nextBlue[1]-=dc[k];
                   }
                }

                //방문 여부 확인하고 예약, 방문 표시
                State newState = new State(nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],now.cnt+1);
                if(!set.contains(newState.toKey())){
                    set.add(newState.toKey());
                    q.add(newState);
                }

            }

        }

        return 0;

    }


}

class State {
    int rr;
    int rc;
    int br;
    int bc;
    int cnt;

    public State(int rr,int rc,int br,int bc, int cnt){
        this.rr=rr;
        this.rc=rc;
        this.br=br;
        this.bc=bc;
        this.cnt=cnt;
    }

    public String toKey(){
        return rr+","+rc+","+br+","+bc;
    }
}