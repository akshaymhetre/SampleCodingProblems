package com.akshay.learning.graphType;

import java.util.*;
public class Djkstras {
    int dist[];
    Set<Integer> visited;
    PriorityQueue<Node> pqueue;
    int totalVertices; // Number of vertices
    List<List<Node> > adjList;
    //class constructor
    public Djkstras(int totalVertices) {
        this.totalVertices = totalVertices;
        dist = new int[totalVertices];
        visited = new HashSet<>();
        pqueue = new PriorityQueue<>(totalVertices, new Node());
    }

    // Dijkstra's Algorithm implementation
    public void shortestPath(List<List<Node>> adjList, int srcVertex)
    {
        this.adjList = adjList;

        // set distance to infinity
        for (int i = 0; i < totalVertices; i++)
            dist[i] = Integer.MAX_VALUE;

        // first add source vertex to PriorityQueue
        pqueue.add(new Node(srcVertex, 0));

        // Distance to the source from itself is 0
        dist[srcVertex] = 0;
        while (pqueue.size() != 0) {
            // u is removed from PriorityQueue and has min distance
            Node nextSrcNode = pqueue.poll();
            for (int i = 0; i < adjList.get(nextSrcNode.vertex).size(); i++) {
                Node nextDestVertex = adjList.get(nextSrcNode.vertex).get(i);
                dist[nextDestVertex.vertex] = Math.min(dist[nextDestVertex.vertex], nextSrcNode.weight+nextDestVertex.weight);
                pqueue.add(new Node(nextDestVertex.vertex, dist[nextDestVertex.vertex]));
            }
        }
    }
    // this methods processes all neighbours of the just visited node
    private void graph_adjacentNodes(int u)   {
        int edgeDistance = -1;
        int newDistance = -1;

        // process all neighbouring nodes of u
        for (int i = 0; i < adjList.get(u).size(); i++) {
            Node v = adjList.get(u).get(i);

            //  proceed only if current node is not in 'visited'
            if (!visited.contains(v.vertex)) {
                edgeDistance = v.weight;
                newDistance = dist[u] + edgeDistance;

                // compare distances
                if (newDistance < dist[v.vertex])
                    dist[v.vertex] = newDistance;

                // Add the current vertex to the PriorityQueue
                pqueue.add(new Node(v.vertex, dist[v.vertex]));
            }
        }
    }
}
class Main{
    public static void main(String arg[])   {
        int V = 6;
        int source = 0;
        // adjacency list representation of graph
        List<List<Node>> adj_list = new ArrayList<List<Node> >();
        // Initialize adjacency list for every node in the graph
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj_list.add(item);
        }


        // Input graph edges
        adj_list.get(0).add(new Node(1, 5));
        adj_list.get(0).add(new Node(2, 3));
        adj_list.get(0).add(new Node(3, 2));
        adj_list.get(0).add(new Node(4, 3));
        adj_list.get(0).add(new Node(5, 3));
        adj_list.get(2).add(new Node(1, 2));
        adj_list.get(2).add(new Node(3, 3));
        // call Dijkstra's algo method
        Djkstras dpq = new Djkstras(V);
        dpq.shortestPath(adj_list, source);

        // Print the shortest path from source node to all the nodes
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t "  + dpq.dist[i]);
    }
}

// Node class
class Node implements Comparator<Node> {
    public int vertex;
    public int weight;
    public Node() { } //empty constructor

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    @Override
    public int compare(Node node1, Node node2){
        return node1.weight-node2.weight;
    }
}