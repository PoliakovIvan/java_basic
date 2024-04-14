package com.example;

import java.util.Random;
import java.util.Scanner;

public class MatrixApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter matrix formation method (R - random or M - manual): ");
        String formationMethod = scanner.nextLine();

        System.out.print("Enter matrix height (number between 1 and 20): ");
        int height = scanner.nextInt();

        System.out.print("Enter matrix width (number between 1 and 20): ");
        int width = scanner.nextInt();

        Matrix matrix = new Matrix(height, width, formationMethod);

        System.out.println(String.format("Min value in matrix: %d", matrix.min()));
        System.out.println(String.format("Max value in matrix: %d", matrix.max()));
        System.out.println(String.format("Average value of matrix: %.2f", matrix.average()));

        scanner.close();
    }

    private static class Matrix {
        private int height;
        private int width;
        private String formationMethod;
        private int[][] values;

        private static final int MIN_RANDOM_VALUE = 0;
        private static final int MAX_RANDOM_VALUE = 100;

        public Matrix(int height, int width, String formationMethod) {
            this.formationMethod = formationMethod;

            if (height > 0 && height <= 20) {
                this.height = height;
            } else {
                throw new IllegalArgumentException("Incorrect matrix height value");
            }

            if (width > 0 && width <= 20) {
                this.width = width;
            } else {
                throw new IllegalArgumentException("Incorrect matrix width value");
            }

            this.values = new int[this.height][this.width];

            if (this.formationMethod.equalsIgnoreCase("R")) {
                Random rand = new Random();
                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        this.values[i][j] = rand.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
                    }
                }
            } else if (this.formationMethod.equalsIgnoreCase("M")) {
                Scanner scanner = new Scanner(System.in);

                for (int i = 0; i < this.height; i++) {
                    for (int j = 0; j < this.width; j++) {
                        System.out.print(String.format("Enter integer value for element at row %d, column %d: ", i, j));
                        this.values[i][j] = scanner.nextInt();
                    }
                }

                scanner.close();
            } else {
                throw new IllegalArgumentException("Incorrect matrix formation method");
            }
        }

        public int min() {
            int minElem = MAX_RANDOM_VALUE + 1;
            for (int[] row : this.values) {
                for (int value : row) {
                    if (value < minElem)
                        minElem = value;
                }
            }
            return minElem;
        }

        public int max() {
            int maxElem = MIN_RANDOM_VALUE - 1;
            for (int[] row : this.values) {
                for (int value : row) {
                    if (value > maxElem)
                        maxElem = value;
                }
            }
            return maxElem;
        }

        public int sum() {
            int sumMatrixElements = 0;
            for (int[] row : this.values) {
                for (int value : row) {
                    sumMatrixElements += value;
                }
            }
            return sumMatrixElements;
        }

        public float average() {
            int matrixSum = this.sum();
            int elementsCount = this.height * this.width;

            if (elementsCount > 0) {
                return (float) matrixSum / elementsCount;
            } else {
                return 0.0f; 
            }
        }
    }
}
