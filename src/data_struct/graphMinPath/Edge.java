package data_struct.graphMinPath;

public class Edge {
    public int sid; // 起始边
    public int tid; // 终止边
    public int w;   // 权重

    public Edge(int s, int t, int w) {
        this.sid = s;
        this.tid = t;
        this.w = w;
    }
}
