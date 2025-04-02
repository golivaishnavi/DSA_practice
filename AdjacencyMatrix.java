//for graph representation
import java.util.*;
class AdjacencyMatrix {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int e=sc.nextInt();
       int[][] adjacencyMat=new int[n][n];
       for(int i=0;i<e;i++){
           int from=sc.nextInt();
           int to=sc.nextInt();
           adjacencyMat[from-1][to-1]=1;
           adjacencyMat[to-1][from-1]=1;
       }
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               System.out.print(adjacencyMat[i][j]+" ");
           }
           System.out.println();
       }
       sc.close();
    }
}
//TC- O(e)
//SC-O(n**n)