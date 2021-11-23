package com.akshay.learning.graphType.weighted;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vertex<T extends Comparable<T>> {
    public T label;
    private Set<Edge<T>> edges;
    public Vertex(T label) {
        this.label = label;
        this.edges = new HashSet<>();
    }

    public void addEdge(Edge<T> edge){
        edges.add(edge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(label, vertex.label) && Objects.equals(edges, vertex.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, edges);
    }
}

