package org.GraphLib.algorithms;

import org.GraphLib.Graph;

import java.util.*;

/**
 * Contains DFS-related algorithms for graph operations.
 */
public class DFSAlgorithms {

    /**
     * Checks if the graph is connected.
     * For undirected graphs, it checks if all nodes are reachable from any node.
     * For directed graphs, it checks if all nodes are reachable from every node.
     *
     * @param graph The graph object.
     * @return `true` if the graph is connected, `false` otherwise.
     */
    public static boolean isConnected(Graph graph) {
        if (graph.getNumNodes() == 0) {
            return true; // An empty graph is considered connected
        }

        if (graph.isDirected()) {
            // For directed graphs, check connectivity from every node
            for (int node : graph.getAdjacencyList().keySet()) {
                if (!isAllNodesReachable(graph, node)) {
                    return false;
                }
            }
            return true;
        } else {
            // For undirected graphs, check connectivity from any single node
            return isAllNodesReachable(graph, graph.getAdjacencyList().keySet().iterator().next());
        }
    }

    /**
     * Checks if all nodes are reachable from a given start node using DFS.
     *
     * @param graph The graph object.
     * @param start The starting node for the DFS traversal.
     * @return `true` if all nodes are reachable, `false` otherwise.
     */
    private static boolean isAllNodesReachable(Graph graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfs(graph, start, visited);
        return visited.size() == graph.getNumNodes();
    }

    /**
     * Performs a Depth-First Search (DFS) traversal from a given node.
     *
     * @param graph   The graph object.
     * @param current The current node being visited.
     * @param visited A set to keep track of visited nodes.
     */
    private static void dfs(Graph graph, int current, Set<Integer> visited) {
        visited.add(current);
        for (int neighbor : graph.getAdjacencyList().get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}