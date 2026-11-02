package Homework7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(String from, String to, int minutes) {
        if (from == null || to == null || !adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        if (minutes <= 0) {
            throw new IllegalArgumentException();
        }

        adjacencyList.get(from).add(new Edge(to, minutes));

    }

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }


    public boolean hasNode(String node) {
        return adjacencyList.containsKey(node);
    }

    public List<Edge> getEdges(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    public static Graph fromFile(Path p) throws IOException {
        Graph graph = new Graph();
        try (BufferedReader reader = Files.newBufferedReader(p)) {
            String line = reader.readLine();
            if (line == null) {
                throw new IllegalArgumentException("File is empty");
            }

            int n = Integer.parseInt(line.trim());
            for (int i = 0; i < n; i++) {
                String node = reader.readLine();
                if (node != null) {
                    graph.addNode(node.trim());
                }
            }

            line = reader.readLine();
            if (line == null) {
                throw new IllegalArgumentException("Missing edges count line");
            }

            int m = Integer.parseInt(line.trim());
            int readEdges = 0;
            while (readEdges < m && (line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Malformed line: " + line);
                }
                String from = parts[0];
                String to = parts[1];
                int minutes = Integer.parseInt(parts[2]);
                graph.addEdge(from, to, minutes);
                readEdges++;
            }
        }
        return graph;
    }
}

