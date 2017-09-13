package implementations;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Пояснение:
 * Ход решения:
 *   -Получаем значения.
 *   -Преобразуем слои в очередь.
 *   -Вращаем матрицу R раз.
 *   -Преобразуем очередь в слои.
 *   -Выводим матрицу на экран.
 */

class MatrixLayerRotation {

    static int[][] matrix;
    static int R;
    static int layer;

    public static void Rotate(int row, int col) {
        Queue<Integer> queue = new LinkedList<Integer>();
        //Преобразуем слои в очередь
        for (int i = 0 + layer; i < col - 1 - layer; i++) {
            queue.add(matrix[0 + layer][i]);
        }
        for (int i = 0 + layer; i < row - 1 - layer; i++) {
            queue.add(matrix[i][col - 1 - layer]);
        }
        for (int i = col - 1 - layer; i > 0 + layer; i--) {
            queue.add(matrix[row - 1 - layer][i]);
        }
        for (int i = row - 1 - layer; i > 0 + layer; i--) {
            queue.add(matrix[i][0 + layer]);
        }
        int redo = R;

        if ((2 * (row - layer * 2) + 2 * (col - layer * 2) - 4) > 0) {
            redo = R % (2 * (row - layer * 2) + 2 * (col - layer * 2) - 4);
        }
        int t;
        for (int i = 0; i < redo; i++) {
            t = queue.poll();
            queue.add(t);
        }

        // Отправляем числа обратно в матрицу
        for (int i = 0 + layer; i < col - 1 - layer; i++) {
            matrix[0 + layer][i] = queue.poll();
        }
        for (int i = 0 + layer; i < row - 1 - layer; i++) {
            matrix[i][col - 1 - layer] = queue.poll();
        }
        for (int i = col - 1 - layer; i > 0 + layer; i--) {
            matrix[row - 1 - layer][i] = queue.poll();
        }
        for (int i = row - 1 - layer; i > 0 + layer; i--) {
            matrix[i][0 + layer] = queue.poll();
        }
        if (layer < col / 2 - 1 && layer < row / 2 - 1) {
            layer++;
            Rotate(row, col);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        layer = 0;
        int M = in.nextInt();
        int N = in.nextInt();
        R = in.nextInt();
        matrix = new int[M][N];

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                matrix[y][x] = in.nextInt();
            }
        }

        Rotate(M, N);
        printMatrix(M, N);
    }

    // Печатаем матрицу
    public static void printMatrix(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}