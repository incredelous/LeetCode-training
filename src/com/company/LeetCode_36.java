package com.company;

public class LeetCode_36 {
    //有效的数独
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(!isRowColValid(board, i, j)) {
                    return false;
                }
                if(!isCellValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRowColValid(char[][] board, int row, int col) {

        for(int i = row + 1; i < 9; i++) {
            if(board[i][col] == '.') {
                continue;
            }
            if(board[i][col] == board[row][col]) {
                return false;
            }
        }
        for(int j = col + 1; j < 9; j++) {
            if(board[row][j] == '.') {
                continue;
            }
            if(board[row][j] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    public boolean isCellValid(char[][] board, int row, int col) {
        int rdist, cdist;
        if(row < 3) {
            rdist = 3 - row;
        } else if(row < 6) {
            rdist = 6 - row;
        } else {
            rdist = 9 - row;
        }

        if(col < 3) {
            cdist = 3 - col;
        } else if(col < 6) {
            cdist = 6 - col;
        } else {
            cdist = 9 - col;
        }

        for(int i = row + 1; i < row + rdist; i++) {
            for(int j = col + 1; j < col + cdist; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
