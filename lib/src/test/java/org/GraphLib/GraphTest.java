package org.GraphLib;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    // Test for the constructor with isDirected parameter
    @Test
    void testConstructorWithIsDirected() {
        Graph graph = new Graph(true);
        assertTrue(graph.isDirected());
        assertEquals(0, graph.getNumNodes());
        assertTrue(graph.getAdjacencyList().isEmpty());
    }

    // Test for the constructor with numNodes and isDirected parameters
    @Test
    void testConstructorWithNumNodesAndIsDirected() {
        Graph graph = new Graph(3, false);
        assertFalse(graph.isDirected());
        assertEquals(3, graph.getNumNodes());
        assertEquals(3, graph.getAdjacencyList().size());
        assertTrue(graph.getAdjacencyList().get(0).isEmpty());
    }

    // Test for addEdge method (directed graph)
    @Test
    void testAddEdgeDirected() {
        Graph graph = new Graph(3, true);
        graph.addEdge(0, 1);
        assertEquals(List.of(1), graph.getAdjacencyList().get(0));
        assertTrue(graph.getAdjacencyList().get(1).isEmpty());
    }

    // Test for addEdge method (undirected graph)
    @Test
    void testAddEdgeUndirected() {
        Graph graph = new Graph(3, false);
        graph.addEdge(0, 1);
        assertEquals(List.of(1), graph.getAdjacencyList().get(0));
        assertEquals(List.of(0), graph.getAdjacencyList().get(1));
    }

    // Test for addEdge method with invalid nodes
    @Test
    void testAddEdgeInvalidNodes() {
        Graph graph = new Graph(3, true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 3));
        assertEquals("Source or destination node does not exist.", exception.getMessage());
    }

    // Test for addEdge with weight (directed graph)
    @Test
    void testAddEdgeWithWeightDirected() {
        Graph graph = new Graph(3, true);
        graph.addEdge(0, 1, 5);
        assertEquals(List.of(1), graph.getAdjacencyList().get(0));
        assertTrue(graph.getAdjacencyList().get(1).isEmpty());
    }

    // Test for addEdge with weight (undirected graph)
    @Test
    void testAddEdgeWithWeightUndirected() {
        Graph graph = new Graph(3, false);
        graph.addEdge(0, 1, 5);
        assertEquals(List.of(1), graph.getAdjacencyList().get(0));
        assertEquals(List.of(0), graph.getAdjacencyList().get(1));
    }

    // Test for addEdge with weight and invalid nodes
    @Test
    void testAddEdgeWithWeightInvalidNodes() {
        Graph graph = new Graph(3, true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 3, 5));
        assertEquals("Source or destination node does not exist.", exception.getMessage());
    }

    // Test for addNodes method with valid input
    @Test
    void testAddNodesValid() {
        Graph graph = new Graph(3, false);
        graph.addNodes(2);
        assertEquals(5, graph.getNumNodes());
        assertTrue(graph.getAdjacencyList().containsKey(3));
        assertTrue(graph.getAdjacencyList().containsKey(4));
    }

    // Test for addNodes method with negative input
    @Test
    void testAddNodesNegative() {
        Graph graph = new Graph(3, false);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addNodes(-1));
        assertEquals("The number of nodes to add cannot be negative.", exception.getMessage());
    }

    // Test for getAdjacencyList method
    @Test
    void testGetAdjacencyList() {
        Graph graph = new Graph(3, false);
        Map<Integer, List<Integer>> adjacencyList = graph.getAdjacencyList();
        assertEquals(3, adjacencyList.size());
        assertTrue(adjacencyList.get(0).isEmpty());
    }

    // Test for isDirected method
    @Test
    void testIsDirected() {
        Graph directedGraph = new Graph(true);
        assertTrue(directedGraph.isDirected());

        Graph undirectedGraph = new Graph(false);
        assertFalse(undirectedGraph.isDirected());
    }

    // Test for getNumNodes method
    @Test
    void testGetNumNodes() {
        Graph graph = new Graph(3, false);
        assertEquals(3, graph.getNumNodes());
    }
}