package koushik.graphs;
import java.util.*;
public class DirectedGraph {
    private ArrayList<Edge>[] graph;
    private class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }

    public DirectedGraph(int v){
        graph = new ArrayList[v];
        for(int i = 0; i< graph.length; i++){
            graph[i]= new ArrayList<>();
        }
    }
    public void createGraph(){
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,5));

        graph[1].add(new Edge(1,2,1));

        graph[3].add(new Edge(3,0,3));
//        graph[0].add(new Edge(0,1,2));
//        graph[0].add(new Edge(0,2,4));
//
//        graph[1].add(new Edge(1,4,-1));
//        graph[1].add(new Edge(1,2,-4));
//
//        graph[2].add(new Edge(2,3,2));
//
//        graph[3].add(new Edge(3,4,4));

//        graph[4].add(new Edge(4,3,2));
//        graph[4].add(new Edge(4,5,5));
    }
    public void display(){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                System.out.print(e.src+"-->"+e.dest+" "+e.weight+" ");
            }
            System.out.println();
        }
    }
    public void dijkstra(int src,int v){
        dijkstra(graph,src,v);
    }
    private class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n,int d){
            this.node=n;
            this.dist=d;
        }
        @Override
        public int compareTo(Pair p){
            return this.dist-p.dist;
        }
    }
    private void dijkstra(ArrayList<Edge>[] graph, int src,int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int[] visited = new int[V];
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair cur = pq.remove();
            if(visited[cur.node]==0){
                visited[cur.node]=1;
                for(int i=0;i<graph[cur.node].size();i++){
                    Edge e = graph[cur.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.weight<dist[v]){
                        dist[v]=dist[u]+e.weight;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println(dist[i]+" ");
        }
    }
    public void bellManFord(int src,int V){
        bellManFord(graph,src,V);
    }
    private void bellManFord(ArrayList<Edge>[] graph,int src,int V){
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        int[] visited = new int[V];
        for(int k=0;k<V-1;k++){
            for(int i=0;i<graph.length;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.weight<dist[v]){
                        dist[v]=dist[u]+e.weight;
                    }
                }
            }
        }
        for(int i : dist){
            System.out.print(i+" ");
        }
    }


    public static void main(String[] args) {
        int v=4;
        DirectedGraph graph = new DirectedGraph(v);
        graph.createGraph();
//        graph.display();
        graph.dijkstra(0,v);
//        graph.bellManFord(3,v);
    }
}
