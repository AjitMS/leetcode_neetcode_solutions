package com.ajitmohs.rnd.amm.com.ajitmohs.rnd.ammall.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for(int rowI = 0; rowI < 9; rowI++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for(int colI = 0; colI < 9; colI++) {
                if(board[rowI][colI] != '.') {
                    if(!rowSet.add(board[rowI][colI])) {
                        return false;
                    }
                }
                if(board[colI][rowI] != '.') {
                    if(!colSet.add(board[colI][rowI])) {
                        return false;
                    }
                }
            }
        }

        // box check
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j+=3) {
                Set<Character> boxSet = new HashSet<>();
                // below loop is for the sub-array
                for(int row = 0; row < 3; row++) {
                    for(int col = 0; col < 3; col++) {
                        if(board[row + i][col + j] != '.') {
                            if(!boxSet.add(board[row + i][col + j])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
                isValidSudoku(new char[][] {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}})
        );
    }
}
