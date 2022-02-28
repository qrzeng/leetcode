package com.qingrong.leetcode;

public class Solution130 {
    private boolean[][] visited;

    private final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new Solution130().solve(board);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            traverse(board, 0, j, m, n);
            traverse(board, m - 1, j, m, n);
        }
        for (int j = 0; j < m; j++) {
            traverse(board, j, 0, m, n);
            traverse(board, j, n - 1, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void traverse(char[][] board, int r, int c, int m, int n) {
        if (board[r][c] == 'X' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        board[r][c] = '#';
        for (int i = 0; i < 4; i++) {
            int x = dir[i][0] + r;
            int y = dir[i][1] + c;
            if (x < 0 || x > m || y < 0 || y > n) {
                continue;
            }
            traverse(board, x, y, m, n);
        }
    }
}
