package de.avensio.graph;

public class Edge {
    private Vertex from;
    private Vertex to;
    private boolean isDirected = true;
    private double weight = 0.0;
    private Edge undirectedOpposite;

    public Edge(Vertex a, Vertex b) {
        this.from = a;
        this.to = b;
    }
    public Edge(Vertex a, Vertex b, double weight) {
        this(a, b);
        this.weight = weight;
    }
    public Edge(Vertex a, Vertex b, boolean isUndirected) {
        this(a, b);
        this.isDirected = !isUndirected;
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

    public boolean isDirected() {
        return this.isDirected;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean hasUndirectedOpposite() {
        return this.undirectedOpposite != null;
    }

    public Edge getUndirectedOpposite() {
        return this.undirectedOpposite;
    }

    /**
     * Beim erstellen eines Graphen muss, wenn eine Kante gerichtet ist
     * die engegengesetzte Kante hinzugefügt werden
     * @param undirectedOpposite Edge
     */
    public void setUndirectedOpposite(Edge undirectedOpposite) {
        this.undirectedOpposite = undirectedOpposite;
    }
}
