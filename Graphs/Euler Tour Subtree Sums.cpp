/**
 * Description: 1D point update, range query where \texttt{comb} is
	* any associative operation. If $N=2^p$ then \texttt{seg[1]==query(0,N-1)}.
 * Time: O(\log N)
 * Source:
	* http://codeforces.com/blog/entry/18051
	* KACTL
 * Verification: SPOJ Fenwick
 */

template<class T> struct Seg { // comb(ID,b) = b
	const T ID = 0; T comb(T a, T b) { return a+b; }
	int n; vector<T> seg;
	void init(int _n) { n = _n; seg.assign(2*n,ID); }
	void pull(int p) { seg[p] = comb(seg[2*p],seg[2*p+1]); }
	void upd(int p, T val) { // set val at position p
		seg[p += n] = val; for (p /= 2; p; p /= 2) pull(p); }
	T query(int l, int r) {	// sum on interval [l, r]
		T ra = ID, rb = ID;
		for (l += n, r += n+1; l < r; l /= 2, r /= 2) {
			if (l&1) ra = comb(ra,seg[l++]);
			if (r&1) rb = comb(seg[--r],rb);
		}
		return comb(ra,rb);
	}
};

Seg<ll> S;
int v[MX];

int main() {
	int n,q; cin >> n >> q;
	FOR(i,1,n+1) cin >> v[i];
	F0R(i,n-1) {
		int a,b; cin >> a >> b;
		adj[a].pb(b), adj[b].pb(a); 
	}
	dfs(1,0); // dfs to increment the fist time the node is found (s[n]) and the last (e[n]) in the dfs function
	S.init(n);
	FOR(i,1,n+1) S.upd(st[i],v[i]); // note that each value of s[n] is unique thus it may be 
  //placed in a segment tree, the arrays represent the ids of the node
	F0R(i,q) {
		int t; cin >> t;
		if (t == 1) {
			int s,x; cin >> s >> x;
			S.upd(st[s],x);  // segement trr update
		} else {
			int s; cin >> s;
			cout << S.query(st[s],en[s]) << "\n"; // output the sum of the values
		}
	}
}
