package com.backtracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 0,   0, 7, 0,   0, 0, 0},
                {6, 0, 0,   1, 9, 5,   0, 0, 0},
                {0, 9, 8,   0, 0, 0,   0, 6, 0},

                {8, 0, 0,   0, 6, 0,   0, 0, 3},
                {4, 0, 0,   8, 0, 3,   0, 0, 1},
                {7, 0, 0,   0, 2, 0,   0, 0, 6},

                {0, 6, 0,   0, 0, 0,   2, 8, 0},
                {0, 0, 0,   4, 1, 9,   0, 0, 5},
                {0, 0, 0,   0, 8, 0,   0, 7, 9}
        };
//        if(solve(grid)){
//            display(grid);
//        }
//        else{
//            System.out.println("Cannot be solved");
//        }
//        System.out.println();
        Solve(grid);


    }
    //solving without using extra parameter
    private static boolean solve(int[][] grid) {

       int row = -1;
       int col = -1;
       boolean blank = false;
       //checking the index of blank spaces
       for(int i = 0; i < grid.length; i++){
           for(int j = 0; j < grid.length; j++){
               if(grid[i][j] == 0){
                   row = i;
                   col = j;
                   blank = true;
                   break;
               }
           }
           if(blank){
               break;
           }
       }
       if(!blank){
           //sudoku is solved
           return true;
       }
       for(int num = 1; num <= 9; num++){
           if(isSafe(grid, row, col, num)){
               grid[row][col] = num;
               if(solve(grid)){
                   return true;
               }
               else {
                   grid[row][col] = 0;
               }
           }
       }
       return false;
    }
    private static void Solve(int[][] grid) {

        int row = -1;
        int col = -1;
        boolean blank = false;
        //checking the index of blank spaces
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == 0){
                    row = i;
                    col = j;
                    blank = true;
                    break;
                }
            }
            if(blank){
                break;
            }
        }
        if(!blank){
            //sudoku is solved
            display(grid);
            return;
        }
        for(int num = 1; num <= 9; num++){
            if(isSafe(grid, row, col, num)){
                grid[row][col] = num;
                Solve(grid);
                grid[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] grid, int row, int col, int target) {

        for(int i = 0; i < grid.length; i++) {
            if (grid[i][col] == target || grid[row][i] == target) {
                return false;
            }
        }

        int rStart = row - row % 3;
        int cStart = col - col % 3;
        for(int i = rStart; i < rStart+3; i++) {
            for (int j = cStart; j < cStart+3; j++) {
                if (grid[i][j] == target) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void display(int[][] grid) {
        int vSpace = 1;
        int hSpace = 1;
        for(int[] row : grid){
            for(int num : row){
                if(vSpace == 3){
                    System.out.print(num + " ");
                    System.out.print("  ");
                    vSpace = 1;
                }else{
                    vSpace++;
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            if(hSpace == 3){
                hSpace = 1;
                System.out.println();
            }
            else{
                hSpace++;
            }

        }
    }
}
















