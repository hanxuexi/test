package data_struct.graphMinPath;

import java.util.Queue;

public class PriorityQueue {


    private Vertex[] nodes;
    private int count;

    private int start = 0;
    private int end = 0;

    public PriorityQueue(int v) {
        this.nodes = new Vertex[v + 1];
        this.count = v;
    }

    public Vertex poll() {
        return this.nodes[start++];
    }

    public void add(Vertex vertex) {
        nodes[end++] = vertex;
    }

    public void update(Vertex vertex) {

    }

    public boolean isEmpty() {
        return start == end ? true : false;
    }

}
