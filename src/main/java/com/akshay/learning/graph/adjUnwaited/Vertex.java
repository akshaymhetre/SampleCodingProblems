package com.akshay.learning.graph.adjUnwaited;

import java.util.Objects;

class Vertex<T extends Comparable<T>> {
    public T label;
    public Vertex(T label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}

