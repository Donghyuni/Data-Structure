import java.util.*;

class Node implements Comparable<Node> {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node argO) {
        return Integer.compare(this.distance, argO.distance);
    }
}

public class shortestpath {
    private static final int INF = Integer.MAX_VALUE;

    public static void Dijkstra(List<List<Node>> list, int start) {
        int V = list.size();
        int[] distance = new int[V];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int vertex = current.vertex;
            int dist = current.distance;

            if (dist > distance[vertex])
                continue;

            for (Node neighbor : list.get(vertex)) {
                int newDist = dist + neighbor.distance;
                if (newDist < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDist;
                    queue.offer(new Node(neighbor.vertex, newDist));
                }
            }
        }

        for (int i = 1; i < V; i++) {
            if (distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int start = scanner.nextInt();

        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            list.get(u).add(new Node(v, w));
        }

        Dijkstra(list, start);

        scanner.close();
    }
}
