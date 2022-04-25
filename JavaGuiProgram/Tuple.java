import java.util.*;

public class Tuple <A,B,C,D,E>{
    private A firstItem;
    private B secondItem;
    private C thirdItem;
    private D fourthItem;
    private E fifthItem;

    Tuple(){
        /* null prerameter constructor*/
        this.firstItem = null;
        this.secondItem = null;
        this.thirdItem = null;
        this.fourthItem = null;
        this.fifthItem = null;
    }
    Tuple(A first,B second,C third,D fourth,E fifth){
        /* multiple constructor */
        this.firstItem = first;
        this.secondItem = second;
        this.thirdItem = third;
        this.fourthItem = fourth;
        this.fifthItem = fifth;
    }
    public void setFirst(A item){
        this.firstItem = item;
    }
    public void setSecond(B item){
        this.secondItem = item;
    }
    public void setThird(C item){
        this.thirdItem = item;
    }
    public void setFourth(D item){
        this.fourthItem = item;
    }
    public void setFifth(E item){
        this.fifthItem = item;
    }
    public A getFirst(){
        return this.firstItem;
    }
    public B getSecond(){
        return this.secondItem;
    }
    public C getThird(){
        return this.thirdItem;
    }
    public D getFourth(){
        return this.fourthItem;
    }
    public E getFifth(){
        return this.fifthItem;
    }

    public static void main(String[] args){
        Tuple<String,String,String,String,String> positions = new Tuple<String,String,String,String,String>();
        positions.setFirst("1");
        positions.setSecond("2");
        positions.setThird("3");
        positions.setFourth("4");
        int first = Integer.parseInt(positions.getFirst()) * 2;
        int second = Integer.parseInt(positions.getSecond()) * 2;
        int third = Integer.parseInt(positions.getThird()) * 2;
        int fourth = Integer.parseInt(positions.getFourth()) * 2;

        System.out.println(first + " " + second + " " + third + " " + fourth);
    }
}
