static int[][] grid; // the grid itself
static int n, m; // grid dimensions, rows and columns
static boolean[][] visited; // keeps track of which nodes have been visited
static int currentSize = 0; // reset to 0 each time we start a new component

public static void main(String[] args){
    /**
    * input code and other problem-specific stuff here
    */
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(!visited[i][j]){
                currentSize = 0;
                floodfill(i, j, grid[i][j]);
                // start a floodfill if the square hasn't already been visited,
                // and then store or otherwise use the component size
                // for whatever it's needed for
            }
        }
    }
}
// You will want to use a iterative implementation in usaoc to avoid stack overflow.
static void floodfill(int r, int c, int color){
    if(r < 0 || r >= n || c < 0 || c >= m) return; // if outside grid
    if(grid[r][c] != color) return; // wrong color
    if(visited[r][c]) return; // already visited this square
    visited[r][c] = true; // mark current square as visited
    currentSize++; // increment the size for each square we visit 
    // ^ also input problem specific stuff for the node here
    // recursively call floodfill for neighboring squares
    floodfill(r, c+1, color);
    floodfill(r, c-1, color);
    floodfill(r-1, c, color);
    floodfill(r+1, c, color);
}
