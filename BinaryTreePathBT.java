import java.util.*;
/*
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/
public class BinaryTreePathBT{
    public static void traverse(Node root,List<Integer> path,List<List<Integer>> ans){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(path));
        }
        else{
            traverse(root.left,path,ans);
            traverse(root.right,path,ans);
        }
        path.remove(path.size()-1);
    }
    public static List<List<Integer>> treepaths(Node root) {
        //Write your code here...
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        List<Integer> path=new ArrayList<>();
        traverse(root,path,ans);
        return ans;
    }
}
//TC-O(N)
//SC-O(H) ( for path)+O(H)(for recursion stack space)