package de.avensio.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Vertex> vertices = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public Graph() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex g = new Vertex("G");
        Vertex s = new Vertex("S");

        this.edges.add(new Edge(c, s));
        this.edges.add(new Edge(s, c));

        this.edges.add(new Edge(s, a));
        this.edges.add(new Edge(a, s));

        this.edges.add(new Edge(s, e));
        this.edges.add(new Edge(e, s));

        this.edges.add(new Edge(c, b));
        this.edges.add(new Edge(b, c));

        this.edges.add(new Edge(b, e));
        this.edges.add(new Edge(e, b));

        this.edges.add(new Edge(e, d));
        this.edges.add(new Edge(d, e));


        this.edges.add(new Edge(d, g));
        this.edges.add(new Edge(g, d));

        this.vertices.addAll(Arrays.asList(new Vertex[]{a, b, c, d, e, g, s}));
    }

    public Set<Vertex> getNeighbours(Vertex a) {
        Set<Vertex> result = new HashSet<>();

        for (Edge x: this.edges) {
            Vertex from = x.getFrom();
            Vertex to = x.getTo();

            if (from.getName() == a.getName()) {
                System.out.println(from.getName() + " -> " + to.getName());
                result.add(to);
            } else if (to.getName() == a.getName()) {
                System.out.println(from.getName() + " -> " + to.getName());
                result.add(from);
            }
        }
        System.out.print("Neighbours: ");
        for (Vertex v: result) {
            System.out.print(v.getName() + " ");
        }
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.getNeighbours(new Vertex("E"));
    }
}
