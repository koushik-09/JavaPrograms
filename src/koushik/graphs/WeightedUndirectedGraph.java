package koushik.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class WeightedUndirectedGraph {
    private ArrayList<Edge>[] graph;
    private class Edge{
        int dest;
        int weight;
        public Edge(int d,int w){
            this.dest=d;
            this.weight=w;
        }
    }
    public WeightedUndirectedGraph(int v){
        graph=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
    }
    private class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n,int d){
            this.node=n;
            this.dist=d;
        }
        public int compareTo(Pair p){
            return this.dist-p.dist;
        }
    }
    public void primsAlgo(int V){
        primsAlgo(graph,V);
    }
    private void primsAlgo(ArrayList<Edge>[] graph,int V){
        int cost=0;
        int[] visited = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair cur = pq.remove();
            if(visited[cur.node]==0){
                visited[cur.node]=1;
                cost+=cur.dist;
                for(int i=0;i<graph[cur.node].size();i++){
                    Edge e = graph[cur.node].get(i);
                    if(visited[e.dest]==0){
                        pq.add(new Pair(e.dest,e.weight));
                    }
                }
            }
        }
        System.out.println(cost);
    }
    public void createGraph(){
        graph[0].add(new Edge(1,10));
        graph[0].add(new Edge(2,15));
        graph[0].add(new Edge(3,30));

        graph[1].add(new Edge(0,10));
        graph[1].add(new Edge(3,40));

        graph[2].add(new Edge(0,15));
        graph[2].add(new Edge(3,50));

        graph[3].add(new Edge(0,30));
        graph[3].add(new Edge(1,10));
        graph[3].add(new Edge(2,50));
    }

    public static void main(String[] args) {
        int v=4;
        WeightedUndirectedGraph graph = new WeightedUndirectedGraph(v);
        graph.createGraph();
        graph.primsAlgo(v);
    }
}
