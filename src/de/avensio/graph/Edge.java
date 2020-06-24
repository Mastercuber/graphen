package de.avensio.graph;

public class Edge {
    private Vertex from;
    private Vertex to;
    private int weight = 0;

    public Edge(Vertex a, Vertex b) {
        this.from = a;
        this.to = b;
    }

    public Vertex[] getVertices() {
        return new Vertex[]{this.from, this.to};
    }

    public Vertex getFrom() {
        return this.from;
    }

    public Vertex getTo() {
        return this.to;
    }
}
