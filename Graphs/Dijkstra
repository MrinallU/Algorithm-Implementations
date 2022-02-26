import java.io.*;
import java.util.*;

public class Dijkstra {
    static Kattio io;
    static {
        io = new Kattio();
    }

    static int n, m;
    static ArrayList<pair> graph[];
    static long dist[];
    
    static void dijkstra(int src) {
        for (int i = 0; i < n; ++i)
            dist[i] = Long.MAX_VALUE;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new pair(src, 0));
        while(!pq.isEmpty()) {
            pair p = pq.poll();
            long cdist = p.y;
            int node = p.x;
            if(cdist != dist[node])
                continue;
            for (pair i : graph[node]) {
                if(cdist+i.y < dist[i.x]) {
                    dist[i.x] = cdist + i.y;
                    pq.add(new pair(i.x, dist[i.x]));
                }
            }
        }
    }

    public static void main(String[] args) {
        n = io.nextInt();
        m = io.nextInt();

        graph = new ArrayList[n];
        dist = new long[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<pair>();
        }

        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();
            graph[a - 1].add(new pair(b - 1, c));
            graph[b - 1].add(new pair(a - 1, c));
        }


        io.close();
    }
    
    public static class pair implements  Comparable<pair>{

        private final int x;
        private final long y;

        public pair(final int x, final long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof pair)) {
                return false;
            }

            final pair pair = (pair) o;

            if (x != pair.x) {
                return false;
            }
            if (y != pair.y) {
                return false;
            }

            return true;
        }

        @Override
        public int compareTo(pair pair) {
            return Long.compare(this.y, pair.y);
        }
    }
 }
