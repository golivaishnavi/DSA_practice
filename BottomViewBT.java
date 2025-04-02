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

public class BottomViewBT{
    public static List<Integer> bottomView(Node root) {
        //Write your code here...
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> m=new TreeMap<>();
        Queue<Map.Entry<Node,Map.Entry<Integer,Integer>>> q=new ArrayDeque<>();
        q.add(new AbstractMap.SimpleEntry<>(root,new AbstractMap.SimpleEntry<>(0,0)));
        while(!q.isEmpty()){
            Map.Entry<Node,Map.Entry<Integer,Integer>> front=q.poll();
            Node cur=front.getKey();
            int row=front.getValue().getKey();
            int col=front.getValue().getValue();
            m.putIfAbsent(col,new TreeMap<>());
            m.get(col).putIfAbsent(row,new ArrayList<>());
            m.get(col).get(row).add(cur.data);
            if(cur.left!=null){
                q.add(new AbstractMap.SimpleEntry<>(cur.left,new AbstractMap.SimpleEntry<>(row+1,col-1)));
            }
            if(cur.right!=null){
                q.add(new AbstractMap.SimpleEntry<>(cur.right,new AbstractMap.SimpleEntry<>(row+1,col+1)));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> col:m.entrySet()){
            Map.Entry<Integer,List<Integer>> row=col.getValue().lastEntry();
            List<Integer> a=row.getValue();
            ans.add(a.get(a.size()-1));
        }
        return ans;
    }
}
//another approach
/*
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


public class Solution{
    public static class Pair<F,S>{
        public F first;
        public S second;
        public Pair(F first,S second){
            this.first=first;
            this.second=second;
        }
    }
    public static List<Integer> bottomView(Node root) {
        //Write your code here...
        Queue<Pair<Node,Integer>> q=new LinkedList<>();
        Map<Integer,Integer> m=new TreeMap<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            Pair<Node,Integer> front=q.poll();
            Node cur=front.first;
            int col=front.second;
            
            m.put(col,cur.data);
            if(cur.left!=null){
                q.add(new Pair<>(cur.left,col-1));
            }
            if(cur.right!=null){
                q.add(new Pair<>(cur.right,col+1));
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int d:m.values()){
            ans.add(d);
        }
        return ans;
    }
}
 */
//tc-O(NLOGN)
//SC-O(N)