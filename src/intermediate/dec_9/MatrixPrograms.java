package intermediate.dec_9;

import java.util.Scanner;

public class MatrixPrograms {


    static class Matrix {
        // Define properties here

        Matrix() {
        }
        // Define constructor here


        void input(Scanner sc) {
            int row = sc.nextInt();
            System.out.println("Please enter the columns in the matrix");
            int column = sc.nextInt();

            int[][] first = new int[row][column];
            int[][] second = new int[row][column];

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    System.out.println(String.format("Enter first[%d][%d] integer", r, c));
                    first[r][c] = sc.nextInt();
                }
            }

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    System.out.println(String.format("Enter second[%d][%d] integer", r, c));
                    second[r][c] = sc.nextInt();
                }
            }
            // Use the Scanner object passed as argument for taking input and not a new Scanner object
            // Complete the function

        }

        Matrix add(Matrix x) {
            // Complete the function
            return new Matrix();
        }

        Matrix subtract(Matrix x) {
            // Complete the function
            return new Matrix();
        }

        Matrix transpose() {
            // Complete the function
            return new Matrix();
        }

//        void print() {
//            // Complete the function
//            for (int r = 0; r < matrix.length; r++) {
//                for (int c = 0; c < matrix[0].length; c++) {
//                    System.out.print(matrix[r][c] + "\t");
//                }
//                System.out.println();
//            }
//        }
    }
}