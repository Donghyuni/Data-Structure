import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int start, end;
    double weight;

    Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}

public class boj4386 {
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // 변경된 부분: 경로 압축(Path Compression) 적용
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }

    static double kruskal() {
        double cost = 0.0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            double weight = edge.weight;

            if (find(start) != find(end)) { // 변경된 부분: 두 노드의 부모가 다른 경우에만 union 수행
                union(start, end);
                cost += weight;
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<double[]> stars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new double[]{x, y});
        }

        for (int i = 0; i < n - 1; i++) {
            double[] starA = stars.get(i);
            for (int j = i + 1; j < n; j++) {
                double[] starB = stars.get(j);
                double distance = Math.sqrt(Math.pow(starA[0] - starB[0], 2) + Math.pow(starA[1] - starB[1], 2));
                pq.add(new Edge(i + 1, j + 1, distance));
            }
        }

        double minimumCost = kruskal();
        System.out.printf("%.2f", minimumCost);
    }
}
