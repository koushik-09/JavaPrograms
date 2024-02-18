package koushik.practice;
import java.lang.reflect.Array;
import java.util.*;
public class Graph {
    HashMap<String,ArrayList> graph=new HashMap<String,ArrayList>();
    public void addVertex(String vertex){
        if(graph.containsKey(vertex)){
            System.out.println("Cannot add vertex");
        }
        else{
            ArrayList<String> temp=new ArrayList<String>();
            graph.put(vertex,temp);
        }
    }
    public void addEdge(String vertex1,String vertex2){
        if(graph.containsKey(vertex1)){
            graph.get(vertex1).add(vertex2);
        }
        else{
            addVertex(vertex1);
            addEdge(vertex1,vertex2);
        }
    }
    public void DepthFirstSearch(String f){
        ArrayList<String> visited=new ArrayList<>();
        ArrayList<String> first=graph.get(f);
        Stack<String> stack=new Stack<>();
        visited.add(f);
        for(String i:first){
            stack.push(i);
        }
        while(!stack.empty()){
            String pop=stack.pop();
            visited.add(pop);
            ArrayList<String> temp=graph.get(pop);
            for(String i:temp){
                stack.push(i);
            }
        }
        System.out.println(visited);
    }
    public static void main(String[] args) {
        Graph obj=new Graph();
        obj.addVertex("1");
        obj.addVertex("2");
        obj.addVertex("3");
        obj.addVertex("4");
        obj.addVertex("5");
        obj.addVertex("6");
        obj.addEdge("1","2");
        obj.addEdge("1","3");
        obj.addEdge("2","5");
        obj.addEdge("4","6");
        obj.addEdge("5","4");
        obj.addEdge("3","4");
        obj.DepthFirstSearch("1");
        System.out.println(obj.graph);
    }

}