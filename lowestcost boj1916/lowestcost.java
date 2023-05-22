import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num;
    int cost;

    Node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node arg0) {
        return cost - arg0.cost;
    }
    
}

public class lowestcost {
    static int N, M;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] check;

    public static int Dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.num;

            if(!check[cur]) {
                check[cur] = true;

                for(Node node : list.get(cur)){
                    if(!check[node.num] && dist[node.num] > dist[cur] + node.cost){
                        dist[node.num] = dist[cur] + node.cost;
                        pq.add(new Node(node.num, dist[node.num]));
                    }
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dist = new int[N+1];
        check = new boolean[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        bw.write(Dijkstra(startPoint, endPoint) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
