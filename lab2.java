import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    private int[][] matrix;
    private int rows;
    private int cols;
    private final int MAX_SIZE = 20;
    private final int RANDOM_RANGE = 100; 

    public MatrixOperations(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public void inputMatrixFromKeyboard(Scanner scanner) {
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            System.out.printf("Row %d: ", i + 1);
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            
            if (elements.length != cols) {
                System.out.println("Incorrect number of elements. Please try again.");
                i--;
                continue;
            }
            
            for (int j = 0; j < cols; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid element value. Please try again.");
                    i--;
                    break;
                }
            }
        }
    }

    public void generateRandomMatrix() {
        Random random = new Random();
        System.out.println("Randomly generated matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(RANDOM_RANGE);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int findMinElement() {
        int min = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public int findMaxElement() {
        int max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }
        return sum / (rows * cols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows, cols;

        System.out.println("Enter the number of rows in the matrix (not more than 20):");
        rows = scanner.nextInt();
        System.out.println("Enter the number of columns in the matrix (not more than 20):");
        cols = scanner.nextInt();
        
        if (rows > 20 || cols > 20) {
            System.out.println("The matrix size exceeds the allowable limit.");
            return;
        }
        
        MatrixOperations matrixOps = new MatrixOperations(rows, cols);
        
        System.out.println("Choose the method of creating the matrix:\n1. Enter from keyboard\n2. Generate randomly");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                scanner.nextLine(); // Consume newline character
                matrixOps.inputMatrixFromKeyboard(scanner);
                break;
            case 2:
                matrixOps.generateRandomMatrix();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        
        int min = matrixOps.findMinElement();
        int max = matrixOps.findMaxElement();
        double average = matrixOps.calculateAverage();
        
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
        System.out.println("Average: " + average);
        
        scanner.close();
    }
}
