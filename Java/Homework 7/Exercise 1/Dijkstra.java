package Homework7;

import java.util.*;

public class Dijkstra {
    private record NodeDist(String node, int dist) implements Comparable<NodeDist> {
        @Override
        public int compareTo(NodeDist other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    public static Result shortestPath(Graph g, String src, String dst) {
        if (!g.hasNode(src)) {
            throw new NoSuchElementException("Unknown source node: " + src);
        }
        if (!g.hasNode(dst)) {
            throw new NoSuchElementException("Unknown destination node: " + dst);
        }

        if (src.equals(dst)) {
            return new Result(List.of(src), 0);
        }

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<NodeDist> pq = new PriorityQueue<>();

        dist.put(src, 0);
        pq.add(new NodeDist(src, 0));
        /*
         * LAZY DELETION:
         * PriorityQueue may contain many old entries for the same node that have bigger distances.
         * Before handling a node taken from the priority queue we compare the distance stored in the queue entry, with the distance that we have already fixed in the 'dist' map.
         * If current.dist > dist.get(current.node) this entry is old. We skip it.
         * This ensures that each node is fixed at once and keeps the time complexity O((N + M) log N).
         */
        while (!pq.isEmpty()) {
            NodeDist current = pq.poll();
            String u = current.node();
            int d = current.dist();

            if (d > dist.getOrDefault(u, Integer.MAX_VALUE)) {
                continue;
            }

            if (u.equals(dst)) {
                break;
            }

            for (Edge edge : g.getEdges(u)) {
                String v = edge.to();
                int weight = edge.minutes();
                int newDist = d + weight;

                if (newDist < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, newDist);
                    prev.put(v, u);
                    pq.add(new NodeDist(v, newDist));
                }
            }
        }

        if (!dist.containsKey(dst)) {
            return Result.Unreachable;
        }

        List<String> path = new ArrayList<>();
        for (String at = dst; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        return new Result(path, dist.get(dst));
    }
}

