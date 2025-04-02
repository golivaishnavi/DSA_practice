import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDFS {
    public static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int v) {
        //Write your code here...
        int[] colors=new int[v];
        Arrays.fill(colors,-1);
        for(int i=0;i<v;i++){
            if(colors[i]==-1){
                if(dfs(i,adj,colors,0)){
                    return true;
                }
            }
            
        }
        return false;
        
    }
    public static boolean dfs(int start,ArrayList<ArrayList<Integer>> adj,int[] colors,int parent){
        colors[start]=parent;
        for(int k:adj.get(start)){
            if(colors[k]==-1){
                if(!dfs(k,adj,colors,1-parent)){
                    return false;
                }
            }
            else if(colors[k]==colors[start]){
                return false;
            }
        }
        return true;
    }
}
//TC-O(N+2*E) for dfs calls
//SC-O(N) for additional space && O(N) for recursion stack space
