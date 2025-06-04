import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

    public static int visited[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        visited=new int[1000001];

        int start = sc.nextInt();
        int end = sc.nextInt();

        ArrayDeque<Integer>q = new ArrayDeque<>();
        q.add(start);
        visited[start]=1;

        while(!q.isEmpty()){

            int now = q.poll();

            if(now==end){
                System.out.println(visited[now]-1);
                break;
            }

            int pos[] = {now-1,now+1,now*2};

            for(int i=0;i<3;i++){
                if(pos[i]<0||pos[i]>100000){
                    continue;
                }

                if(visited[pos[i]]==0){
                    q.add(pos[i]);
                    visited[pos[i]]=visited[now]+1;
                }
            }

        }

    }
}