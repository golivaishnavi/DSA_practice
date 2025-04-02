//for graph representation
import java.util.*;
class AdjacencyList {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int e=sc.nextInt();
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
           adj.add(new ArrayList<Integer>());
       }
       for(int i=0;i<e;i++){
           int from=sc.nextInt();
           int to=sc.nextInt();
           adj.get(from).add(to);
           adj.get(to).add(from);
       }
       for(int i=1;i<=n;i++){
           System.out.print(i+"- ");
           for(int k:adj.get(i)){
               System.out.print(k+" ");
           }
           System.out.println();
       }
       sc.close();
    }
} 
//TC-O(E)
//SC-O(2E) for undirected graph and O(E) for directed graph
/*
 import java.util.*;
public class Solution {
    public static List<List<Integer>> adjList() {
        // Write your code here...
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
        
        return adj;
    }
    
}
 */