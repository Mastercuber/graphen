package de.avensio.graph;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    private String name;
    private Set<Edge> outgoingEdges = new HashSet<>();
    private Set<Edge> incomingEdges = new HashSet<>();

    public Vertex(String name) {
        this.name = name;
    }

    /**
     *  Alle Nachbarknoten dieses Knotens finden.
     * @return neighbours
     */
    public Set<Vertex> getNeighbours() {
        Set<Vertex> neighbours = new HashSet<>();
        for (Edge e: this.outgoingEdges) {
            neighbours.add(e.getTo());
        }
        for (Edge e: this.incomingEdges) {
            neighbours.add(e.getFrom());
        }

        return neighbours;
    }

    /**
     *  Alle erreichbaren Nachbarknoten dieses Knotens finden.
     *  Die Rückgabe Menge wird im Skript auch Adjazenzlisten benannt.
     * @return reachableNeighbours
     */
    public Set<Vertex> getReachableNeighbours() {
        Set<Vertex> neighbours = new HashSet<>();
        for (Edge e: this.outgoingEdges) {
            neighbours.add(e.getTo());
        }
        return neighbours;
    }

    public String getName() { return this.name; }

    public Set<Edge> getOutgoingEdges() {
        return this.outgoingEdges;
    }

    public Set<Edge> getIncomingEdges() {
        return this.incomingEdges;
    }

    public void addIncomingEdge(Edge e) {
        this.incomingEdges.add(e);
    }

    public void removeIncomingEdge(Edge e) {
        this.incomingEdges.remove(e);
    }

    public void addOutgoingEdge(Edge e) {
        this.outgoingEdges.add(e);
    }

    public void removeOutgoingEdge(Edge e) {
        this.outgoingEdges.remove(e);
    }

    /** Definition 1.1.4
     *
     *  Der Grad eines Knotens v ist die Anzahl seiner Nachbarn und wird
     *  mit deg(v) bezeichnet
     */
    public int deg() {
        return this.getReachableNeighbours().size();
    }

    /**
     * Eingangsgrad gibt an, von wie vielen anderen Knoten aus dieser erreichbar ist
     * @return indegree
     */
    public int indeg() {
        int edges = this.getIncomingEdges().size();
        System.out.println("\nEingangsgrad (" + this.getName() + "): " + edges);
        return edges;
    }

    /**
     * Ausgangsgrad gibt an, wie viele Knoten von diesem Knoten aus erreichbar sind
     *
     * @return outdegree
     */
    public int outdeg() {
        int outputDegree = this.getOutgoingEdges().size();
        System.out.println("Ausgangsgrad (" + this.getName() + "): " + outputDegree);
        return outputDegree;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
