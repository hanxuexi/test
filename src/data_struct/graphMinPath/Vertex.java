package data_struct.graphMinPath;

// 这个类是为了dijkstra实现用的
public class Vertex {

    public int id;  // 顶点编号ID
    public int dist; // 从起始顶点到这个顶点的距离

    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}

