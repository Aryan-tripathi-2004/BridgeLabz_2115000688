import java.util.Random;

public class MatrixOperations {
    public static void main(String[] args) {
        Random random = new Random();
        
        int rows = 3, cols = 3;
        int[][] matrix1 = createRandomMatrix(rows, cols);
        int[][] matrix2 = createRandomMatrix(rows, cols);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        int[][] addedMatrix = addMatrices(matrix1, matrix2);
        System.out.println("Matrix 1 + Matrix 2:");
        displayMatrix(addedMatrix);

        int[][] subtractedMatrix = subtractMatrices(matrix1, matrix2);
        System.out.println("Matrix 1 - Matrix 2:");
        displayMatrix(subtractedMatrix);

        int[][] multipliedMatrix = multiplyMatrices(matrix1, matrix2);
        System.out.println("Matrix 1 * Matrix 2:");
        displayMatrix(multipliedMatrix);

        int[][] transposedMatrix = transposeMatrix(matrix1);
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposedMatrix);

        double determinantMatrix1 = determinantOf2x2Matrix(matrix1);
        System.out.println("Determinant of Matrix 1 (2x2): " + determinantMatrix1);

        double determinantMatrix2 = determinantOf3x3Matrix(matrix2);
        System.out.println("Determinant of Matrix 2 (3x3): " + determinantMatrix2);

        double[][] inverseMatrix1 = inverseOf2x2Matrix(matrix1);
        System.out.println("Inverse of Matrix 1 (2x2):");
        displayMatrix(inverseMatrix1);
        
        double[][] inverseMatrix2 = inverseOf3x3Matrix(matrix2);
        System.out.println("Inverse of Matrix 2 (3x3):");
        displayMatrix(inverseMatrix2);
    }

    public static int[][] createRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // Random number between 0 and 9
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static double determinantOf2x2Matrix(int[][] matrix) {
        if (matrix.length == 2 && matrix[0].length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        return 0;
    }

    public static double determinantOf3x3Matrix(int[][] matrix) {
        if (matrix.length == 3 && matrix[0].length == 3) {
            double det = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                    - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                    + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
            return det;
        }
        return 0;
    }

    public static double[][] inverseOf2x2Matrix(int[][] matrix) {
        double[][] inverse = new double[2][2];
        double det = determinantOf2x2Matrix(matrix);
        if (det != 0) {
            inverse[0][0] = matrix[1][1] / det;
            inverse[0][1] = -matrix[0][1] / det;
            inverse[1][0] = -matrix[1][0] / det;
            inverse[1][1] = matrix[0][0] / det;
        }
        return inverse;
    }

    public static double[][] inverseOf3x3Matrix(int[][] matrix) {
        double[][] inverse = new double[3][3];
        double det = determinantOf3x3Matrix(matrix);
        if (det != 0) {
            inverse[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) / det;
            inverse[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) / det;
            inverse[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / det;
            inverse[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) / det;
            inverse[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / det;
            inverse[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]) / det;
            inverse[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) / det;
            inverse[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1]) / det;
            inverse[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) / det;
        }
        return inverse;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%.2f", matrix[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
