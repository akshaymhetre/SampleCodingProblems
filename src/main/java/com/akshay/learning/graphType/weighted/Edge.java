package com.akshay.learning.graphType.weighted;

import java.util.Objects;

public class Edge<T extends Comparable<T>> {
    private Vertex<T> to;
    private int weight;

    public Edge(Vertex<T> to, int weight) {
        super();
        this.to = to;
        this.weight = weight;
    }

    Vertex<T> getTo() {
        return to;
    }

    int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight && Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, weight);
    }
}
