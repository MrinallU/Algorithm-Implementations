import java.io.*;
import java.util.*;

public class Main {
	static int n, comp;
	static DisjointSets DSU;
	static long ans;
	static long [] arr;
	static PriorityQueue<pair> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		kruskal();
	}

	public static long kruskal() {
		while (!pq.isEmpty()) {
			pair e = pq.poll();
			if (DSU.find(e.x) != DSU.find(e.y)) {
				DSU.union(e.x, e.y);
				ans += e.w;
				if(comp == 1)
					return ans; // terminate when a tree is created to avoid TLE and bc optimal answer is found.
			}
		}
	}


	private static class DisjointSets {
		int[] parents;  // 0-indexed
		int[] sizes;
		public DisjointSets(int size) {
			sizes = new int[size];
			parents = new int[size];
			Arrays.fill(sizes, 1);
			Arrays.fill(parents, -1);
		}

		// finds the "representative" node in a's component
		public int find(int x) {
			return parents[x] == -1 ? x : (parents[x] = find(parents[x]));
		}

		// returns whether the merge changed connectivity
		public boolean union(int x, int y) {
			int xRoot = find(x);
			int yRoot = find(y);
			if (xRoot == yRoot) {
				return false;
			}
			if (sizes[xRoot] < sizes[yRoot]) {
				parents[xRoot] = yRoot;
				sizes[yRoot] += sizes[xRoot];
				comp--;
			} else {
				parents[yRoot] = xRoot;
				sizes[xRoot] += sizes[yRoot];
				--comp;
			}
			return true;
		}

		// returns whether two nodes are in the same connected component
		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}
	}

	public static class pair implements  Comparable<pair>{

		private final int x;
		private final int y;
		private long w;

		public pair(final int x, final int y, long c) {
			this.x = x;
			this.y = y;
			w = c;
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
			return Long.compare(pair.w, this.w);
		}
	}
