import java.util.*;
class Bfs {
    public static List<Integer> bfs(int n,List<List<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        boolean visited[] =new boolean[n];
        visited[0]=true;
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int k:adj.get(curr)){
                if(!visited[k]){
                    q.add(k);
                    visited[k]=true;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int e=sc.nextInt();
       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
           adj.add(new ArrayList<Integer>());
       }
       for(int i=0;i<e;i++){
           int from=sc.nextInt();
           int to=sc.nextInt();
           adj.get(from).add(to);
           adj.get(to).add(from);
       }
       List<Integer> res=bfs(n,adj);
       for(int i:res){
           System.out.print(i+" ");
       }
       sc.close();
    }
}
//TC-O(n+2*e) n for adding n nodes to queue and 2*e for checking neighbours of a node
//SC-O(3N)