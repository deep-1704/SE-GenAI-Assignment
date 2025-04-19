package org.GraphLib.algorithms;

import org.GraphLib.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DFSAlgorithmsTest {

    // Test for isConnected with an undirected connected graph
    @Test
    void testIsConnectedUndirectedConnected() {
        Graph graph = new Graph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        assertTrue(DFSAlgorithms.isConnected(graph));
    }

    // Test for isConnected with an undirected disconnected graph
    @Test
    void testIsConnectedUndirectedDisconnected() {
        Graph graph = new Graph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        assertFalse(DFSAlgorithms.isConnected(graph));
    }

    // Test for isConnected with a directed connected graph
    @Test
    void testIsConnectedDirectedConnected() {
        Graph graph = new Graph(4, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // Adding a cycle to make it strongly connected

        assertTrue(DFSAlgorithms.isConnected(graph));
    }

    // Test for isConnected with a directed disconnected graph
    @Test
    void testIsConnectedDirectedDisconnected() {
        Graph graph = new Graph(4, true);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);

        assertFalse(DFSAlgorithms.isConnected(graph));
    }

    // Test for isConnected with an empty graph
    @Test
    void testIsConnectedEmptyGraph() {
        Graph graph = new Graph(0, false);
        assertTrue(DFSAlgorithms.isConnected(graph)); // An empty graph is considered connected
    }

    // Test for isConnected with a single node
    @Test
    void testIsConnectedSingleNode() {
        Graph graph = new Graph(1, false);
        assertTrue(DFSAlgorithms.isConnected(graph)); // A single node graph is connected
    }

    // Test for isConnected with a self-loop in a directed graph
    @Test
    void testIsConnectedDirectedSelfLoop() {
        Graph graph = new Graph(3, true);
        graph.addEdge(0, 0);
        graph.addEdge(1, 2);

        assertFalse(DFSAlgorithms.isConnected(graph));
    }
}