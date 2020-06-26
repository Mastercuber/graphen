package de.avensio.graph;

import java.util.HashSet;
import java.util.Set;

// Weg der Länge k durch den Graph -> durchlaufene Kanten zählen nicht Knoten

/**
 * Die in dieser Klasse als Kommentare angegebenen Definitionen und Sätze sind aus dem Vorlesungssrkipt zur Vorlesung
 * Algorithem auf Graphen an der Hochschule Karlsruhe - Technik und Wirtschaft entnommen
 * und über deren fortlaufende Nummern im Skript zu finden
 */

public class Graph {
    private Set<Vertex> vertices = new HashSet<>(); // Knoten
    private Set<Edge> edges = new HashSet<>(); // Kanten
    private Set<Graph> connectedComponents = new HashSet<>(); // Zusammenhangskomponenten
    private int connectedComponentsCount = 1;
    private boolean isDirected = false; // gerichtet/ungerichtet
    private int verticesCount = 0; // Knotenanzahl
    private int edgesCount = 0; // Kantenanzahl
    private boolean hasCycles = true; // Zyklisch
    private int cycleCount = 0; // Azyklisch

    public Graph() {
    }

    public Graph(Set<Vertex> vertices, Set<Edge> edges)  {
        this.vertices = vertices;
        this.edges = edges;
        this.inferDirected();
    }

    public boolean cyclic() {
        return this.hasCycles;
    }

    public boolean acyclic() {
        return !this.hasCycles;
    }

    public int cyclicCount() {
        return this.cycleCount;
    }


    public boolean checkForCycles() {

        return true;
    }

    // Definition 1.1.2
    // Ein ungerichteter Graph G ist zusammenhängend, wenn es zwischen
    // je zwei verschiedenen Knoten in G mindestens einen Weg gibt.
    // Siehe auch Beweis zu Satz 1.1.13
    private boolean connected() {
        return true;
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
        return (this.acyclic() && this.verticesCount - 1 == this.edgesCount)
            || (this.connected() && this.verticesCount - 1 == this.edgesCount);
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
        if (this.acyclic() && !this.isDirected) {
            this.verticesCount = this.edges.size() + this.connectedComponentsCount;
        } else if (this.connectedComponentsCount == 1) {
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

    /**
     * Definition 1.1.9 Zusammenhangskomponente
     * Sei G = (V, E) ein ungerichteter Graph. Eine Zusammenhangskomponente
     * von G ist eine Teilmenge Z ⊆ V von Knoten, so dass gilt:
     * ∀v, w ∈ Z : es existiert in G ein Weg von v nach w
     * ∀v not(∈) Z : ∃ w ∈ Z : es existiert in G kein Weg von v nach w
     */
    private Set<Graph> connectedComponents() {
        return null;
    }


    public Set<Vertex> breadthFirstSearch() {
        return new HashSet<>();
    }

    public static void main(String[] args) {
        Graph g = Utils.createDirectedGraph118();
        for(Vertex x: g.vertices) {
            x.getReachableNeighbours();
            x.indeg();
            x.outdeg();
            System.out.println("isDirected: " + g.isDirected());
            System.out.println();
        }
    }
}
