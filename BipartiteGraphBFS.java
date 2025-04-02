import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {
    public static boolean bipartite(ArrayList<ArrayList<Integer>> adj) {
        //Write your code here...
        int n=adj.size();
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(n,adj,color)){
                    return false;
                }
            }
        }
        return true;
        
    }
    public static boolean bfs(int n,ArrayList<ArrayList<Integer>>adj,int[] color){
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        color[0]=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int k:adj.get(curr)){
              if(color[k]==-1){
                  color[k]=1-color[curr];
                  q.add(k);
              }
              else if(color[k]==color[curr]){
                  return false;
              }
            }
        }
        return true;
    }
}
//no cycle-bipartite
//even cycle-bipartite
//odd cycle-bipartite

//TC-O(N+2*E)
//SC-O(N)
