import java.util.*;

public class Node {
    private int x;
    private int y;
    private int degree;
    private int orderVisited;
    private boolean isVisited;
    private Node nextNode = null;
    public Node(){

    }
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setDegree(int degree){
        this.degree = degree;
    }
    public void setOrderVisited(int order){
        this.orderVisited = order;
    }
    public void setIsVisited(Boolean visited){
        this.isVisited = visited;
    }
    public void setNextNode(Node next){
        this.nextNode = next;

        
    }    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getDegree(){
        return this.degree;
    }
    public int getOrderVisited(){
        return this.orderVisited;
    }
    public boolean getIsVisited(){
        return this.isVisited;
    }
    public Node getNextNode(){
        return this.nextNode;
    }
}