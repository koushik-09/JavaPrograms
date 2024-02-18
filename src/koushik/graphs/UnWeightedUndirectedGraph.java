package koushik.graphs;
import java.util.*;
public class UnWeightedUndirectedGraph {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void createGraph(){
        int s;
        int d;
        System.out.print("Enter the edge: ");
        s=sc.nextInt();
        d=sc.nextInt();
        createGraph(s,d);
    }
    private void createGraph(int[] arr){
        if(arr.length<2){
            System.out.println("Invalid");
            return;
        }
        for(int i=1;i<arr.length;i++){
            createGraph(arr[0],arr[i]);
        }
    }
    private void createGraph(int s,int d){
        if(graph.isEmpty()){
            graph.add(s-1,new ArrayList<>());

        }
        try{
            graph.get(s-1).add(d);
        }
        catch(Exception e){
            graph.add(s-1,new ArrayList<>());
            graph.get(s-1).add(d);
        }
    }
    public void display(){
        System.out.println(graph.size());
        for(int i=0;i< graph.size();i++){
            for(int j=0;j<graph.get(i).size();j++){
                System.out.println((i+1)+"-->"+graph.get(i).get(j));
            }
            System.out.println();
        }
    }
    public void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.size()+1];
        queue.add(1);
//        visited[1]=1;
        while(!queue.isEmpty()){
            int cur=queue.remove();
            if(visited[cur]==0) {
                System.out.print(cur+" ");
                for (int i = 0; i < graph.get(cur - 1).size(); i++) {
                    int temp = graph.get(cur - 1).get(i);
                    if (visited[temp] == 0) {
                        queue.add(temp);
                    }
                }
                visited[cur]=1;
            }
        }
    }
    public void DFS(){
        int[] visited = new int[graph.size()+1];
        try{
            DFS(1,visited);
        }
        catch(Exception e){
            System.out.println("Invalid Node");
        }
    }
    private void DFS(int cur,int[] visited){
        System.out.print(cur+" ");
        visited[cur] = 1;
        for (int i = 0; i < graph.get(cur - 1).size(); i++) {
            int temp = graph.get(cur - 1).get(i);
            if(visited[temp]==0) {
                DFS(graph.get(cur - 1).get(i), visited);
            }
        }
    }
    public void allPaths(int src,int tar){
//        try{
//            allPaths(1,tar,"");
//        }
//        catch(Exception e){
//            System.out.println("Node doesn't exist");
//        }
        int[] visited = new int[graph.size()+1];
        allPaths(visited,1,tar,"1");
    }
    private void allPaths(int[] visited,int cur,int tar,String path){
        if(cur==tar){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph.get(cur - 1).size(); i++) {
            if(visited[cur]==0) {
                path += graph.get(cur - 1).get(i);
                visited[cur]=1;
                allPaths(visited,graph.get(cur - 1).get(i), tar, path);
                visited[cur]=0;
            }
        }
    }
    
    public static void main(String[] args) {
        UnWeightedUndirectedGraph graph = new UnWeightedUndirectedGraph();
        graph.createGraph(new int[]{1,2,3,4});
        graph.createGraph(new int[]{2,1,3,4});
        graph.createGraph(new int[]{3,1,2,5});
        graph.createGraph(new int[]{4,1,2,5});
        graph.createGraph(new int[]{5,3,4});
        graph.allPaths(1,4);
    }


}
