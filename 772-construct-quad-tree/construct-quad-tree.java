/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTree(grid, 0, 0, n);
    }
    private Node constructQuadTree(int[][] grid, int x, int y, int size) {
        // Check if the current sub-grid is a leaf node
        if (isLeaf(grid, x, y, size)) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        } else {
            // Divide the current grid into four sub-grids
            int newSize = size / 2;
            Node topLeft = constructQuadTree(grid, x, y, newSize);
            Node topRight = constructQuadTree(grid, x, y + newSize, newSize);
            Node bottomLeft = constructQuadTree(grid, x + newSize, y, newSize);
            Node bottomRight = constructQuadTree(grid, x + newSize, y + newSize, newSize);
            
            // Create a parent node
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }


    private boolean isLeaf(int[][] grid, int x, int y, int size) {
        int val = grid[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}