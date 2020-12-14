package data_struct.graphMinPath;

import java.util.LinkedList;

public class Graph {

    private int v;// 顶点的个数
    private LinkedList<Edge> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 添加 s->t 的边
    public void addEdge(int s, int t, int w) {
       this.adj[s].add(new Edge(s, t, w));
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public LinkedList<Edge>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Edge>[] adj) {
        this.adj = adj;
    }
}


