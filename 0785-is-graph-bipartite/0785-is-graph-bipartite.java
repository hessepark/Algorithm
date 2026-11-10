import java.util.*;
import java.io.*;

class Solution {

    public static int[] color;

    public boolean isBipartite(int[][] graph) {
        
        color = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                color[i]=-1;
                if(dfs(graph,i)==false){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean dfs(int[][] graph,int n){

        for(int next:graph[n]){
            if(color[next]==0){
                color[next]=-color[n];
                if(dfs(graph,next)==false){
                    return false;
                }
            }
            else{
                if(color[next]==color[n]){
                    return false;
                }
            }
        }

        return true;

    }

}