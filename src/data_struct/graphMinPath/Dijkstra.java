package data_struct.graphMinPath;


import java.util.LinkedList;

public class Dijkstra {

    // 从顶点s到顶点t的最短路径
    public static void dijkstra(Graph graph, int s, int t) {

        LinkedList<Edge> adj[] = graph.getAdj();

        int[] predecessor = new int[graph.getV()]; // 用来还原最短路径
        Vertex[] vertices = new Vertex[graph.getV()];

        for (int i = 0; i < graph.getV(); i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }

        PriorityQueue queue = new PriorityQueue(graph.getV()); // 小顶堆

        boolean[] inqueue = new boolean[graph.getV()]; // 标记是否进入过队列

        vertices[s].dist = 0;
        queue.add(vertices[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除
            if (minVertex.id == t) break; // 最短路径产生了
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge e = adj[minVertex.id].get(i); // 取一条minVertex向量的边
                Vertex nextVertex = vertices[e.tid]; // minVertex --> nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) {
                    // 更新next的dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id] == true) {
                        // 更新队列的dist的值
                        queue.update(nextVertex);
                    } else {
                        // 进队列
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }

        System.out.print(s);
        print(s,t,predecessor);
    }


    private static void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t],predecessor);
        System.out.print("->" + t);
    }


    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,3);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,3);
        graph.addEdge(2,3,1);
        graph.addEdge(3,4,3);

        dijkstra(graph, 0, 4);

    }
}
