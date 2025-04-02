import java.util.*;

public class AsteroidCollisionSTACK {
    public static int[] asteroidCollision(int[] arr) {
        //Write your code here...
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) st.push(arr[i]);
            else{
                while(!st.empty() && st.peek()>0 && arr[i]+st.peek()<0){
                    st.pop();
                }
                if(st.empty()|| st.peek()<0){
                    st.push(arr[i]);
                }
                if(arr[i]+st.peek()==0){
                    st.pop();
                }
            }
        }
        int[] ns=new int[st.size()];
        for(int i=ns.length-1;i>=0;i--){
            ns[i]=st.pop();
        }
        return ns;
    }
    
}