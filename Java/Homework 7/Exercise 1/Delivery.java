package Homework7;

import java.nio.file.Paths;

public class Delivery {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java Delivery <graph-file> <src> <dst>");
            return;
        }

        String filePath = args[0];
        String src = args[1];
        String dst = args[2];

        try {
            Graph graph = Graph.fromFile(Paths.get(filePath));
            Result result = Dijkstra.shortestPath(graph, src, dst);

            if (result.equals(Result.Unreachable)) {
                System.out.println("No route from " + src + " to " + dst + ".");
            } else {
                String pathStr = String.join(" -> ", result.path());
                System.out.println("Fastest route from " + src + " to " + dst + ": " + pathStr + " (" + result.totalMinutes() + " min)");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

