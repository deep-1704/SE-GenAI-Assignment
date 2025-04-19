package org.GraphLib.algorithms;

import org.GraphLib.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BFSAlgorithmsTest {

    // Test for shortestPathFromSource with a valid graph
    @Test
    void testShortestPathFromSourceValid() {
        Graph graph = new Graph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        int[] distances = BFSAlgorithms.shortestPathFromSource(graph, 0);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, distances);
    }

    // Test for shortestPathFromSource with an unreachable node
    @Test
    void testShortestPathFromSourceUnreachableNode() {
        Graph graph = new Graph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        int[] distances = BFSAlgorithms.shortestPathFromSource(graph, 0);
        assertArrayEquals(new int[]{0, 1, 2, -1, -1}, distances);
    }

    // Test for shortestPathFromSource with an invalid source node
    @Test
    void testShortestPathFromSourceInvalidSource() {
        Graph graph = new Graph(3, false);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> BFSAlgorithms.shortestPathFromSource(graph, 5));
        assertEquals("Source node does not exist.", exception.getMessage());
    }

    // Test for isBipartite with a bipartite graph
    @Test
    void testIsBipartiteTrue() {
        Graph graph = new Graph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertTrue(BFSAlgorithms.isBipartite(graph));
    }

    // Test for isBipartite with a non-bipartite graph
    @Test
    void testIsBipartiteFalse() {
        Graph graph = new Graph(3, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        assertFalse(BFSAlgorithms.isBipartite(graph));
    }

    // Test for isBipartite with an empty graph
    @Test
    void testIsBipartiteEmptyGraph() {
        Graph graph = new Graph(0, false);
        assertTrue(BFSAlgorithms.isBipartite(graph)); // An empty graph is considered bipartite
    }

    // Test for isBipartite with a single node
    @Test
    void testIsBipartiteSingleNode() {
        Graph graph = new Graph(1, false);
        assertTrue(BFSAlgorithms.isBipartite(graph)); // A single node graph is bipartite
    }
}