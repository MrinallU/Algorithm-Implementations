                                                                                                                                                                                             
const int MX = 2e5+5;                                                                                                                                                                        
vector<int> adj[MX];                                                                                                                                                                         
int timer = 0, st[MX], en[MX];                                                                                                                                                               
                                                                                                                                                                                             
void dfs(int node, int parent) {                                                                                                                                                             
    st[node] = timer++;                                                                                                                                                                      
    for (int i : adj[node]) {                                                                                                                                                                
        if (i != parent) {                                                                                                                                                                   
            dfs(i, node);                                                                                                                                                                    
        }                                                                                                                                                                                    
    }                                                                                                                                                                                        
    en[node] = timer-1;                                                                                                                                                                      
}                                                                                                                                                                                            
                                                                                                                                                                                             
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
                                                                                                                                                                                             
Seg<int> S;                                                                                                                                                                                  
int v[MX];                                                                                                                                                                                   
void solve(){                                                                                                                                                                                
    int n,q; cin >> n >> q;                                                                                                                                                                  
    for(int i=1; i <= n; i++) cin >> v[i];                                                                                                                                                   
    for(int i=1; i < n; i++){                                                                                                                                                                
        int a,b; cin >> a >> b;                                                                                                                                                              
        adj[a].push_back(b), adj[b].push_back(a);                                                                                                                                            
    }                                                                                                                                                                                        
    dfs(1,0); // create id(s) for each node's entry and exit for the traversal array.                                                                                                        
    S.init(n);                                                                                                                                                                               
                                                                                                                                                                                             
    for(int i=1; i <= n; i++) S.upd(st[i],v[i]);// assign each node's id ot its value (dfs shows that each id tag is unique to the node)                                                     
    for(int i=1; i <= q; i++) {                                                                                                                                                              
        int t; cin >> t;                                                                                                                                                                     
        if (t == 1) {                                                                                                                                                                        
            int s,x; cin >> s >> x;                                                                                                                                                          
            S.upd(st[s],x);                                                                                                                                                                  
        } else {                                                                                                                                                                             
            int s; cin >> s;                                                                                                                                                                 
            cout << S.query(st[s],en[s]) << "\n"; // via segment tree, query the sum of the subtree.                                                                                         
        }                                                                                                                                                                                    
    }                                                                                                                                                                                        
}                                                                                                                                                                                            
                                                                                                                                                                                             
                                                                                                                                                                                             
                                                                                                                                                                                             
int32_t main() {                                                                                                                                                                             
    ios_base::sync_with_stdio(0);                                                                                                                                                            
    cin.tie(0); cout.tie(0);                                                                                                                                                                 
    int tc = 1;                                                                                                                                                                              
//    cin >> tc;                                                                                                                                                                             
                                                                                                                                                                                             
    for (int t = 1; t <= tc; t++) {                                                                                                                                                          
        solve();                                                                                                                                                                             
    }                                                                                                                                                                                        
}                                                                                                                                                                                            