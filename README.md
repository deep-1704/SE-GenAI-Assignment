# SE-GenAI-Assignment

## Overview
GraphLib is a lightweight Java library designed for graph operations and algorithms. It provides an easy-to-use API for creating and manipulating graphs, as well as implementing common graph algorithms such as Breadth-First Search (BFS) and Depth-First Search (DFS). The library supports both directed and undirected graphs and includes features like weighted edges, shortest path calculation, bipartite graph checking, and graph connectivity analysis.

## Features
- Create and manipulate directed and undirected graphs
- Add and remove vertices and edges
- Weighted edges support
- Graph traversal algorithms: BFS and DFS
- Shortest path calculation using Dijkstra's algorithm
- Bipartite graph checking
- Graph connectivity analysis

## Example Usage

### 1. Creating a Graph
```java
import org.GraphLib.Graph;

public class Main {
    public static void main(String[] args) {
        // Create an undirected graph with 5 nodes
        Graph graph = new Graph(5, false);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print adjacency list
        System.out.println(graph.getAdjacencyList());
    }
}
```

### 2. Finding the Shortest Path Using BFS
```java
import org.GraphLib.Graph;
import org.GraphLib.algorithms.BFSAlgorithms;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Find shortest path from node 0
        int[] distances = BFSAlgorithms.shortestPathFromSource(graph, 0);
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from 0 to " + i + ": " + distances[i]);
        }
    }
}
```

### 3. Checking if a Graph is Bipartite
```java
import org.GraphLib.Graph;
import org.GraphLib.algorithms.BFSAlgorithms;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        // Check if the graph is bipartite
        boolean isBipartite = BFSAlgorithms.isBipartite(graph);
        System.out.println("Is the graph bipartite? " + isBipartite);
    }
}
```

### 4. Checking Graph Connectivity Using DFS
```java
import org.GraphLib.Graph;
import org.GraphLib.algorithms.DFSAlgorithms;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Check if the graph is connected
        boolean isConnected = DFSAlgorithms.isConnected(graph);
        System.out.println("Is the graph connected? " + isConnected);
    }
}
```