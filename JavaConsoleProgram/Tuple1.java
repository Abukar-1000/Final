import java.util.*;

public class Tuple1<A,B> {
    private A firstItem;
    private B secondItem;
    Tuple1(){
        /* null prerameter constructor*/
        this.firstItem = null;
        this.secondItem = null;
    }
    Tuple1(A first,B second){
        /* multiple constructor */
        this.firstItem = first;
        this.secondItem = second;
    }
    public void setFirst(A item){
        this.firstItem = item;
    }
    public void setSecond(B item){
        this.secondItem = item;
    }
    public A getFirst(){
        return this.firstItem;
    }
    public B getSecond(){
        return this.secondItem;
    }

    public static void main(String[] args){
        Tuple1<String,String> positions = new Tuple1<String,String>();
        positions.setFirst("1");
        positions.setSecond("2");
        int first = Integer.parseInt(positions.getFirst()) * 2;
        int second = Integer.parseInt(positions.getSecond()) * 2;

        System.out.println(first + " " + second + " ");
    }
}
