package org.GraphLib.algorithms;

import org.GraphLib.Graph;

import java.util.*;

/**
 * Contains BFS-related algorithms for graph operations.
 */
public class BFSAlgorithms {

    /**
     * Finds the shortest path from the source node to all other nodes in an unweighted graph.
     *
     * @param graph  The graph object.
     * @param source The source node.
     * @return An array where the value at index `i` represents the shortest distance from the source to node `i`.
     * @throws IllegalArgumentException If the source node does not exist in the graph.
     */
    public static int[] shortestPathFromSource(Graph graph, int source) {
        if (!graph.getAdjacencyList().containsKey(source)) {
            throw new IllegalArgumentException("Source node does not exist.");
        }

        int[] distances = new int[graph.getNumNodes()];
        Arrays.fill(distances, -1); // Initialize distances as -1 (unreachable)
        distances[source] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.getAdjacencyList().get(current)) {
                if (distances[neighbor] == -1) { // If not visited
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }

    /**
     * Checks if the graph is bipartite using BFS.
     *
     * @param graph The graph object.
     * @return `true` if the graph is bipartite, `false` otherwise.
     */
    public static boolean isBipartite(Graph graph) {
        int[] colors = new int[graph.getNumNodes()];
        Arrays.fill(colors, -1); // -1 means uncolored

        for (int start = 0; start < graph.getNumNodes(); start++) {
            if (colors[start] == -1) { // If not visited
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                colors[start] = 0; // Start coloring with 0

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int neighbor : graph.getAdjacencyList().get(current)) {
                        if (colors[neighbor] == -1) { // If not colored
                            colors[neighbor] = 1 - colors[current]; // Alternate color
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[current]) {
                            return false; // Same color on both sides
                        }
                    }
                }
            }
        }

        return true;
    }
}