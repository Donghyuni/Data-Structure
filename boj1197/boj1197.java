import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int start, end, weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge arg0) {
        return this.weight - arg0.weight;
    }
}

public class boj1197 {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static int Find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = Find(parent[x]);
        return parent[x];
    }

    static void UF(int x, int y) {
        int xrt = Find(x);
        int yrt = Find(y);
        if (xrt != yrt) {
            parent[xrt] = y;
        }
    }

    static int kruskal() {
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int s = poll.start;
            int e = poll.end;
            int w = poll.weight;

            if (Find(s) == Find(e))
                continue;
            UF(s, e);
            sum += w;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            pq.add(new Edge(start, end, weight));
        }
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++)
            parent[i] = i;
        
        int result = kruskal();
        System.out.println(result);
    }
}