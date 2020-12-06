package data_struct;

import utils.TreeNode;

import java.util.LinkedList;

public class Graph {

    private int v;// 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 添加 s->t 的边
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    // top排序
    public void topSortByKahn() {
        // 统计每个顶点的入度
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        // 入度为0的顶点入队列
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            // 输出顶点
            System.out.print("->" + i + " ");
            // 删除以该顶点出发的边（这里没有删除，只是将对应顶点的入度-1）
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.offer(k);
            }
        }
    }

    public void topoSortByDFS() {
        // 先构建逆邻接表
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // i -> w
                inverseAdj[w].add(i); // w -> i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }

    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {

        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        System.out.print("->" + vertex + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.topSortByKahn();
        System.out.println();
        graph.topoSortByDFS();
    }
}
