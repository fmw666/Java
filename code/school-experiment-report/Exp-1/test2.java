import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : Matrix multiplication Problem --");
        Scanner input = new Scanner(System.in);

        System.out.print("Please input the first Matrix(A)'s rows : ");
        int mARow = input.nextInt();
        System.out.print("Please input the first Matrix(A)'s columns : ");
        int mACol = input.nextInt();
        System.out.println();

        System.out.print("Please input the second Matrix(B)'s rows : ");
        int mBRow = input.nextInt();
        System.out.print("Please input the second Matrix(B)'s columns : ");
        int mBCol = input.nextInt();
        System.out.println();
        
        input.close();

        short choose = 0;
        if (mACol != mBRow && mARow != mBCol) {
            System.out.println("Sorry, Matrix A and B can't be multiplied by each other.");
        } else {
            if (mACol == mBRow && mARow == mBCol) {
                System.out.println("Matrix A and B can be multiplied by each other (AB & BA)");
                choose = 3;
            } else {
                if (mACol == mBRow) {
                    System.out.println("Matrix A can be multiplied by Matrix B (AB).");
                    choose = 1;
                }
                if (mARow == mBCol) {
                    System.out.println("Matrix B can be multiplied by Matrix A (BA).");
                    choose = 2;
                }
            }
        }
        System.out.println();

        if (choose > 0) {
            Matrix A = new Matrix(mARow, mACol);
            Matrix B = new Matrix(mBRow, mBCol);

            System.out.println("Please input the first Matrix(A)'s value : ");
            A.setValue();
            System.out.println();

            System.out.println("Please input the second Matrix(B)'s value : ");
            B.setValue();
            System.out.println();

            System.out.println("The first Matrix(A)'s values :");
            A.print();
            System.out.println(A.getSize() + "\n");

            System.out.println("The second Matrix(B)'s values :");
            B.print();
            System.out.println(B.getSize() + "\n");

            if (choose == 1) {
                Matrix C = Matrix.multiply(A, B);

                System.out.println("The Matrix(AB)'s values :");
                C.print();
                System.out.println(C.getSize());

            } else if (choose == 2) {
                Matrix C = Matrix.multiply(B, A);

                System.out.println("The Matrix(BA)'s values :");
                C.print();
                System.out.println(C.getSize());

            } else if (choose == 3) {
                Matrix C1 = Matrix.multiply(A, B);

                System.out.println("The Matrix(AB)'s values :");
                C1.print();
                System.out.println(C1.getSize() + "\n");

                Matrix C2 = Matrix.multiply(B, A);

                System.out.println("The Matrix(BA)'s values :");
                C2.print();
                System.out.println(C2.getSize());
            }
        }
    }
}

/**
 * Matrix
 */
class Matrix {
    private int row;
    private int col;
    private double[][] matrix;

    public Matrix() {
        row = 0;
        col = 0;
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new double[row][col];
    }

    public Matrix(double[][] matrix, int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = matrix;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public String getSize() {
        return "(" + row + "," + col + ")";
    }

    public double getValue(int r, int c) {
        return matrix[r][c];
    }

    public void setValue() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            System.out.println("-> Row " + (i + 1) + "(of " + row + ")");
            for (int j = 0; j < col; j++) {
                System.out.print("Column " + (j + 1) + "(of " + col + "):");
                matrix[i][j] = input.nextDouble();
            }
            if (i != row - 1) {
                System.out.println("---");
            }
        }
    }

    public void setValue(int r, int c, double value) {
        if (r < row && c < col) {
            matrix[r][c] = value;
        }
    }

    public void print(String... tips) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Matrix multiply(Matrix A, Matrix B) {
        int row_c = A.getRow();
        int col_c = B.getColumn();
        Matrix C = new Matrix(row_c, col_c);

        for (int i = 0; i < row_c; i++) {
            for (int j = 0; j < col_c; j++) {
                double value = 0;
                for (int k = 0; k < A.getColumn(); k++) {
                    value += A.getValue(i, k) * B.getValue(k, j);
                }
                C.setValue(i, j, value);
            }
        }
        return C;
    }

}
