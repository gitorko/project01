package com.demo.theory._008_diagnoalmatrix;

import org.junit.jupiter.api.Test;

public class MatrixDiagonal {

    @Test
    public void test() {
        int n = 4;
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {1, 2, 3, 4},
                {5, 6, 7, 8}};
        printPrincipalDiagonal(a, n);
        printSecondaryDiagonal(a, n);
    }

    public void printPrincipalDiagonal(int mat[][], int n) {
        System.out.print("Principal Diagonal: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Condition for principal diagonal
                if (i == j) {
                    System.out.print(mat[i][j] + ", ");
                }
            }
        }
        System.out.println("");
    }

    public void printSecondaryDiagonal(int mat[][], int n) {
        System.out.print("Secondary Diagonal: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Condition for secondary diagonal
                if ((i + j) == (n - 1)) {
                    System.out.print(mat[i][j] + ", ");
                }
            }
        }
        System.out.println("");
    }
}
