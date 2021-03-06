package de.avensio.graph;


// Weg der Länge k durch den Graph -> durchlaufene Kanten zählen nicht Knoten

import java.util.*;

/**
 * Die in dieser Klasse als Kommentare angegebenen Definitionen und Sätze sind aus dem Vorlesungssrkipt zur Vorlesung
 * Algorithem auf Graphen an der Hochschule Karlsruhe - Technik und Wirtschaft entnommen
 * und über deren fortlaufende Nummern im Skript zu finden
 */

public class Graph {
    private Set<Vertex> vertices = new HashSet<>(); // Knoten
    private Set<Edge> edges = new HashSet<>(); // Kanten
    private Set<Graph> connectedComponents = new HashSet<>(); // Zusammenhangskomponenten
    private int connectedComponentsCount = 0;
    private boolean isDirected = false; // gerichtet/ungerichtet
    private int verticesCount = 0; // Knotenanzahl
    private int edgesCount = 0; // Kantenanzahl
    private boolean hasCycles = true; // Zyklisch/Azyklisch
    private int cycleCount = 0; // Zyklenanzahl

    public Graph() {
    }

    public Graph(Set<Vertex> vertices, Set<Edge> edges)  {
        this.vertices = vertices;
        this.edges = edges;
        this.inferDirected();
    }

    public boolean isCyclic() {
        return this.hasCycles;
    }

    public boolean isAcyclic() {
        return !this.hasCycles;
    }

    public int cyclicCount() {
        return this.cycleCount;
    }


    public boolean checkForCycles() {

        return true;
    }

    public boolean isConnected() {
        return this.isConnected(null);
    }

    // Definition 1.1.2
    // Ein ungerichteter Graph G ist zusammenhängend, wenn es zwischen
    // je zwei verschiedenen Knoten in G mindestens einen Weg gibt.
    // Siehe auch Beweis zu Satz 1.1.13
    // @TODO Prüfung auch für gerichtete Graphen
    public boolean isConnected(Set<Vertex> vertices) {
        if (vertices == null) vertices = this.vertices;
        if (this.isDirected() || vertices.size() < 1) return false;
        if (vertices.size() == 1) return true;

        ArrayList<Boolean> connected = new ArrayList<>();

        // Achtung! Schleifen werden hier falsch herum durchlaufen...
        // .. Erst die erste, dann die zweite... Debuggen gibt Aufschluss
        for (Vertex vertex1: vertices) {
            for (Vertex vertex2: vertices) {
                // Sind es dieselben Knoten, mache nichts für diesen Knoten
                if (vertex2.getName() == vertex1.getName()) break;

                for (Edge e: vertex2.getOutgoingEdges()) {
                    if (e.getTo().getName() == vertex1.getName()) {
                        connected.add(true);
                    }
                }

            }
        }

        if (connected.size() == vertices.size()) {
            return connected.stream().allMatch((element) -> element == true);
        }

        return false;
    }

    /**
     * Definition 1.1.12 Ein ungerichteter Graph heißt Baum, wenn er zusammenhängend und azyklisch ist
     */
    /**
     * 1.1.13 Satz Sei G = (V, E) ein ungerichteter Graph mit n Knoten. Dann sind äquiva-
     * lent:
     * a) G ist ein Baum.
     * b) G ist zusammenhängend und hat genau n − 1 Kanten.
     * c) G ist zusammenhängend, aber nach der Entnahme einer beliebigen Kante gilt dies
     * nicht mehr.
     * d) Durch das Hinzufügen einer beliebigen Kante entsteht genau ein (erster) Kreis.
     * e) Es gibt für alle v, w ∈ V genau einen Weg von v nach w.
     * f) G ist kreisfrei und hat genau n − 1 Kanten.
     * @return isTree
     */
    // @TODO Bis jetzt werden nur b) und f) abgebildet
    public boolean isTree() {
        return (this.isAcyclic() && this.verticesCount - 1 == this.edgesCount)
            || (this.isConnected() && this.verticesCount - 1 == this.edgesCount);
    }

    public Set<Vertex> getVertices() {
        return this.vertices;
    }

    public Set<Edge> getEdges() {
        return this.edges;
    }

    /**
     * infers if the graph is directed or undirected and also sets the vertices and edges count
     */
    public void inferDirected() {
        for (Edge edge: this.edges) {
            if (edge.isDirected()) {
                this.isDirected = true;
                break;
            }
        }

        this.edgesCount = 0;
        // Die Summe aller Beträge der Adjazenzlisten ist die Anzahl Kanten im Graph (Unter Beispiel 1.18 im Skript)
        for(Vertex v: this.vertices) {
            this.edgesCount += v.getReachableNeighbours().size();
        }
        /**
         * Die Zusammenhangskomponenten von kreisfreien Graphen besitzen eine interessante Eigenschaft:
         * 1.1.11 Satz Sei G = (V, E) ein kreisfreier ungerichteter Graph mit n Knoten, m Kanten
         * und p Zusammenhangskomponenten. Dann gilt n = m + p.
         */
        if (this.isAcyclic() && !this.isDirected) {
            this.verticesCount = this.edges.size() + this.connectedComponentsCount;
        } else if (this.connectedComponentsCount == 0 || this.connectedComponentsCount == 1) {
            this.verticesCount = this.vertices.size();
        }
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public int getVerticesCount() {
        return this.verticesCount;
    }

    public int getEdgesCount() {
        return this.edgesCount;
    }

    private void getSubSets(Set<Vertex> vertices, Set<Set<Vertex>> subsets) {
        if (vertices.size() <= 1) return;

        for (Vertex v: vertices) {
            Set<Vertex> subset = new HashSet<>(vertices);
            subset.remove(v);
            subsets.add(subset);
            this.getSubSets(subset, subsets);
        }
    }

    /**
     * Definition 1.1.9 Zusammenhangskomponente
     * Sei G = (V, E) ein ungerichteter Graph.
     * Eine Zusammenhangskomponente von G ist eine Teilmenge Z ⊆ V von Knoten, so dass gilt:
     * ∀v, w ∈ Z : es existiert in G ein Weg von v nach w
     * ∀v not(∈) Z : ∃ w ∈ Z : es existiert in G kein Weg von v nach w
     */
    // @TODO Implementieren
    public Set<Graph> connectedComponents() {
        if (this.isConnected()) return this.connectedComponents;

        Set<Set<Vertex>> vertices = new HashSet<>();
        Set<Set<Edge>> edges = new HashSet<>();

        for (Vertex v: this.vertices) {

        }

        /*Set<Set<Vertex>> subsets = new HashSet<>(new HashSet<>());
        Set<Vertex> tmp = new HashSet<>(this.vertices);
        // Eine Kombination ohne Wiederholung Z als Teilmengen von V erstellen
        this.getSubSets(tmp, subsets);

        // ∀v, w ∈ Z : es existiert in G ein Weg von v nach w
        Set<Set<Vertex>> wayExistsSubsets = new HashSet<>();
        for (Set<Vertex> subset: subsets) {
            if (this.isConnected(subset)) {
                wayExistsSubsets.add(subset);
            }
        }*/

        return this.connectedComponents;
    }

    // Tiefensuche (Gibt alle von s aus erreichbaren Knoten an)
    public Set<Vertex> depthFirstSearch(Vertex s) {
        Stack<Vertex> Q = new Stack<>();
        HashMap<Vertex, List<Vertex>> N = new HashMap<>();
        Set<Vertex> result = new HashSet<>();

        Q.push(s);
        N.put(s, new ArrayList<>(s.getReachableNeighbours()));

        while (!Q.isEmpty()) {
            Vertex v = Q.peek();

            if (N.get(v).size() != 0) {
                Vertex v2 = N.get(v).get(0);
                N.get(v).remove(v2);
                if (!result.contains(v2)) {
                    Q.push(v2);
                    result.add(v2);
                    N.put(v2, new ArrayList<>(v2.getReachableNeighbours()));
                }
            } else {
                Q.pop();
            }
        }
        result.remove(s);
        System.out.println("DFS Ergebnisse für " + s.getName() + ":\n" + result.toString() + "\n");
        return result;
    }

    // Breitensuche (Gibt alle von s aus erreichbaren Knoten an)[wie getReachableNeighbours() blos rekursiv]
    public Set<Vertex> breadthFirstSearch(Vertex s) {
        Queue<Vertex> Q = new LinkedList<>();
        HashMap<Vertex, List<Vertex>> N = new HashMap<>();
        Set<Vertex> result = new HashSet<>();

        Q.add(s);
        N.put(s, new ArrayList<>(s.getReachableNeighbours()));

        while (!Q.isEmpty()) {
            Vertex v = Q.peek();

            if (N.get(v).size() != 0) {
                Vertex v2 = N.get(v).get(0);
                N.get(v).remove(v2);

                if (!result.contains(v2)) {
                    Q.add(v2);
                    result.add(v2);
                    N.put(v2, new ArrayList<>(v2.getReachableNeighbours()));
                }
            } else {
                Q.remove();
            }
        }
        result.remove(s);
        System.out.println("BFS Ergebnisse für " + s.getName() + ":\n" + result.toString() + "\n");
        return result;
    }

    public static void main(String[] args) {
        Graph g = Factory.createDirectedGraph118();
        for(Vertex x: g.vertices) {
            x.getReachableNeighbours();
            x.getNeighbours();
            x.indeg();
            x.outdeg();
            x.getOutgoingEdges();
            x.getIncomingEdges();
            x.getName();
            g.depthFirstSearch(x);
            g.breadthFirstSearch(x);
        }
        System.out.println("isDirected: " + g.isDirected());
    }
}
