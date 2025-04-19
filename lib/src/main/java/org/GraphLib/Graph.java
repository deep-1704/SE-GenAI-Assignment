package org.GraphLib;

import java.util.*;

public class Graph {
    private boolean isDirected;
    private int numNodes;
    private Map<Integer, List<Integer>> adjacencyList;

    // Constructor: Specify if the graph is directed
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        this.numNodes = 0;
        this.adjacencyList = new HashMap<>();
    }

    // Constructor: Specify number of nodes and if the graph is directed
    public Graph(int numNodes, boolean isDirected) {
        this.isDirected = isDirected;
        this.numNodes = numNodes;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    // Getters
    public boolean isDirected() {
        return isDirected;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Adds an edge between two nodes in the graph.
     * For directed graphs, the edge is added from the source to the destination.
     * For undirected graphs, the edge is added in both directions.
     *
     * @param source      The source node of the edge.
     * @param destination The destination node of the edge.
     * @throws IllegalArgumentException If the source or destination node does not exist in the graph.
     */
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            throw new IllegalArgumentException("Source or destination node does not exist.");
        }
        adjacencyList.get(source).add(destination);
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    /**
     * Adds an edge between two nodes in the graph with a specified weight.
     * For directed graphs, the edge is added from the source to the destination.
     * For undirected graphs, the edge is added in both directions.
     *
     * @param source      The source node of the edge.
     * @param destination The destination node of the edge.
     * @param weight      The weight of the edge.
     * @throws IllegalArgumentException If the source or destination node does not exist in the graph.
     */
    public void addEdge(int source, int destination, int weight) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            throw new IllegalArgumentException("Source or destination node does not exist.");
        }
        adjacencyList.get(source).add(destination); // Store weight in a separate structure if needed
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    /**
     * Adds additional nodes to the graph.
     * Updates the adjacency list to include the new nodes.
     *
     * @param count The number of nodes to add.
     * @throws IllegalArgumentException If the count is negative.
     */
    public void addNodes(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("The number of nodes to add cannot be negative.");
        }
        for (int i = numNodes; i < numNodes + count; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        numNodes += count;
    }
}