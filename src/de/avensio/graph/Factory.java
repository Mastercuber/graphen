package de.avensio.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Factory {
    public static Graph createDirectedGraph118() {
        return createDirectedGraph118(new HashSet<>(), new HashSet<>());
    }

    public static Graph createDirectedGraph118(Set<Vertex> vertices, Set<Edge> edges) {
        Vertex one = new Vertex("1");
        Vertex two = new Vertex("2");
        Vertex three = new Vertex("3");
        Vertex four = new Vertex("4");
        Vertex five = new Vertex("5");
        Vertex six = new Vertex("6");
        Vertex seven = new Vertex("7");

        createDirectedEdge(one, four, edges);
        createDirectedEdge(four, six, edges);
        createDirectedEdge(seven, four, edges);
        createDirectedEdge(four, two, edges);
        createDirectedEdge(seven, two, edges);
        createDirectedEdge(two, three, edges);
        createDirectedEdge(five, three, edges);

        vertices.addAll(Arrays.asList(new Vertex[]{one,two,three,four,five,six,seven}));

        return new Graph(vertices, edges);
    }

    public static Graph createDirectedGraph(Set<Vertex> vertices, Set<Edge> edges) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        createDirectedEdge(a, b, edges);
        createDirectedEdge(e, a, edges);
        createDirectedEdge(e, f, edges);
        createDirectedEdge(b, e, edges);
        createDirectedEdge(b, f, edges);
        createDirectedEdge(b, c, edges);
        createDirectedEdge(f, g, edges);
        createDirectedEdge(g, f, edges);
        createDirectedEdge(c, g, edges);
        createDirectedEdge(g, h, edges);
        createDirectedEdge(d, h, edges);
        createDirectedEdge(d, c, edges);
        createDirectedEdge(c, d, edges);

        vertices.addAll(Arrays.asList(new Vertex[]{a,b,c,d,e,f,g,h}));

        return new Graph(vertices, edges);
    }

    public static Graph createDirectedGraph() {
        return createDirectedGraph(new HashSet<>(), new HashSet<>());
    }

    // Beispiel Graph 1.1.10 links
    // Bennennung der Knoten finden von oben nach unten Zeilenweise statt mit fortlaufenden Zahlen
    // Siehe ExampleUndirectedGraph-1.1.10-left
    public static Graph createUndirectedGraph1110left() {
        return createUndirectedGraph1110left(new HashSet<>(), new HashSet<>());
    }

    /**
     * Hilfsfunktion zum erstellen einer ungerichteten Kante
     *
     * @param from
     * @param to
     * @param edges
     */
    private static void createUndirectedEdge(Vertex from, Vertex to, Set<Edge> edges) {
        Edge fromTo = new Edge(from, to, true);
        Edge toFrom = new Edge(to, from, true);
        from.addOutgoingEdge(fromTo);
        to.addIncomingEdge(fromTo);
        from.addIncomingEdge(toFrom);
        to.addOutgoingEdge(toFrom);

        edges.add(fromTo);
        edges.add(toFrom);
    }

    /**
     * Hilfsfunktion zum erstellen einer gerichteten Kante
     *
     * @param from
     * @param to
     * @param edges
     */
    private static void createDirectedEdge(Vertex from, Vertex to, Set<Edge> edges) {
        Edge fromTo = new Edge(from, to);
        from.addOutgoingEdge(fromTo);
        to.addIncomingEdge(fromTo);

        edges.add(fromTo);
    }

    public static Graph createUndirectedGraph1110left(Set<Vertex> vertices, Set<Edge> edges) {
        Vertex one = new Vertex("1");
        Vertex two = new Vertex("2");
        Vertex three = new Vertex("3");
        Vertex four = new Vertex("4");
        Vertex five = new Vertex("5");
        Vertex six = new Vertex("6");
        Vertex seven = new Vertex("7");

        createUndirectedEdge(one, four, edges);
        createUndirectedEdge(four, two, edges);
        createUndirectedEdge(four, seven, edges);
        createUndirectedEdge(two, seven, edges);

        createUndirectedEdge(three, five, edges);

        vertices.addAll(Arrays.asList(new Vertex[]{one, two, three, four, five, six, seven}));

        return new Graph(vertices, edges);
    }

    public static Graph createUndirectedGraph1110right() {
        return createUndirectedGraph1110right(new HashSet<>(), new HashSet<>());
    }

    // Beispiel Graph 1.1.10 rechts
    // Bennennung der Knoten finden von oben nach unten Zeilenweise statt mit fortlaufenden Zahlen
    // Siehe ExampleUndirectedGraph-1.1.10-right
    public static Graph createUndirectedGraph1110right(Set<Vertex> vertices, Set<Edge> edges) {
        Vertex one = new Vertex("1");
        Vertex two = new Vertex("2");
        Vertex three = new Vertex("3");
        Vertex four = new Vertex("4");
        Vertex five = new Vertex("5");
        Vertex six = new Vertex("6");
        Vertex seven = new Vertex("7");

        createUndirectedEdge(one, five, edges);

        createUndirectedEdge(two, six, edges);
        createUndirectedEdge(six, three, edges);
        createUndirectedEdge(six, four, edges);
        createUndirectedEdge(six, seven, edges);

        vertices.addAll(Arrays.asList(new Vertex[]{one, two, three, four, five, six, seven}));

        return new Graph(vertices, edges);
    }

    public static Graph createUndirectedGraph(Set<Vertex> vertices, Set<Edge> edges) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex g = new Vertex("G");
        Vertex s = new Vertex("S");

        createUndirectedEdge(c, s, edges);
        createUndirectedEdge(s, a, edges);
        createUndirectedEdge(s, e, edges);
        createUndirectedEdge(c, b, edges);
        createUndirectedEdge(b, e, edges);
        createUndirectedEdge(e, d, edges);
        createUndirectedEdge(d, g, edges);

        vertices.addAll(Arrays.asList(new Vertex[]{a, b, c, d, e, g, s}));

        return new Graph(vertices, edges);
    }

    public static Graph createUndirectedGraph() {
        return createUndirectedGraph(new HashSet<>(), new HashSet<>());
    }
}
