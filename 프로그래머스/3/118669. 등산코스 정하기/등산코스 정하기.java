import java.util.*;
import java.io.*;

//산봉우리 정렬
//출발점 0 넣어서 거쳐서 못 가게
//산봉우리에서 못 뻗어나가게

//더 큰걸로 업데이트는 해주지만 작을수록 좋다.
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        HashSet<Integer>set = new HashSet<>();
        
        for(int i=0;i<summits.length;i++) {
            set.add(summits[i]);
        }
        
        Arrays.sort(summits);
        
        ArrayList<Node>list[]=new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int [] path:paths){
            int u=path[0];
            int v=path[1];
            int w=path[2];
            
            list[u].add(new Node(v,w));
            list[v].add(new Node(u,w));
        }
        
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        for(int i=0;i<gates.length;i++){
            dist[gates[i]]=0; //출발점으로 지정
        }
        
        PriorityQueue<Node>q = new PriorityQueue<>();
        
        for(int i=0;i<gates.length;i++){
            q.add(new Node(gates[i],0));
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(set.contains(now.node)||dist[now.node]<now.cost) continue;
            
            for(Node next:list[now.node]) {
                
                int nextIntensity=Math.max(next.cost,dist[now.node]);
                
                if(dist[next.node]>nextIntensity){
                    dist[next.node]=nextIntensity;
                    q.add(new Node(next.node,nextIntensity));
                }
                
                
            }
        }
        
        int answer[]=new int[]{0,Integer.MAX_VALUE};
        
        for(int i=0;i<summits.length;i++) {
            if(dist[summits[i]]<answer[1]){
                answer[1]=dist[summits[i]];
                answer[0]=summits[i];
            }
        }
    
        return answer;
    }
}

class Node implements Comparable<Node> {
    int node;
    int cost;
    
    public Node(int node, int cost) {
        this.node=node;
        this.cost=cost;
    }
    
    @Override
    public int compareTo(Node other){
        return this.cost - other.cost;
    }
}