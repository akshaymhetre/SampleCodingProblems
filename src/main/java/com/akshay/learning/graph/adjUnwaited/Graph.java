package com.akshay.learning.graph.adjUnwaited;

import java.util.*;

public class Graph<T extends Comparable<T>> {
    private Map<Vertex<T>, List<Vertex<T>>> adjVertices = new LinkedHashMap<>();
    void addVertex(T label) {
        adjVertices.putIfAbsent(new Vertex<>(label), new ArrayList<>());
    }

    public Set<Vertex<T>> getVertices() {
        return adjVertices.keySet();
    }

    public List<Vertex<T>> getEdgedVertices(Vertex<T> v) {
        return adjVertices.get(v);
    }

    void removeVertex(T label) {
        Vertex<T> v = new Vertex<>(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<>(label));
    }

    void addEdge(T vertex1, T vertex2) {
        Vertex<T> v1 = new Vertex<>(vertex1);
        Vertex<T> v2 = new Vertex<>(vertex2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void addDirectedEdge(T vertex1, T vertex2) {
        Vertex<T> v1 = new Vertex<>(vertex1);
        Vertex<T> v2 = new Vertex<>(vertex2);
        adjVertices.get(v1).add(v2);
    }

    void removeEdge(T vertex1, T vertex2) {
        Vertex<T> v1 = new Vertex<>(vertex1);
        Vertex<T> v2 = new Vertex<>(vertex2);
        List<Vertex<T>> eV1 = adjVertices.get(v1);
        List<Vertex<T>> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }
}
