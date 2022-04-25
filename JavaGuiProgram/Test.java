import java.util.*;
public class Test{
    public static void main(String[] args){
        HashMap<Integer,Node> map = new HashMap<Integer,Node>();
        int[] keys = {1,2,3};
        map.put(1, new Node(0,0));
        map.put(2, new Node(1,0));
        map.put(3, new Node(3,0));
        for (int x = 0; x < map.size(); ++x){
            Node item = map.get(keys[x]);
            System.out.println("X: " + item.getX() + " " + item.getY());
        }
    }
}