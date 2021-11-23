package com.akshay.learning.graphType.weighted;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T extends Comparable<T>> {

    private Set<Vertex<T>> vertices; //collection of all verices

    public Graph() {
        vertices = new HashSet<>();
    }

    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(vertices);
    }

    public boolean addVertex(Vertex<T> vertex){
        return vertices.add(vertex);
    }
}
