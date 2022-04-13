import java.util.Scanner;
public class MatrixChain_Final {
    private static final int INF = Integer.MAX_VALUE;
    static int[][] matrix;
    static int[][] c;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("곱할 행렬의 개수를 입력 : ");
        n = scanner.nextInt();
        matrix = new int[n][2];
        c = new int[n][n];

        System.out.println("각 행렬의 크기를 입력");
        for (int i = 0; i < n; i++)
        {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        minimum(0, n - 1);
        System.out.println("곱셈횟수의 최솟값은 : " + c[0][n - 1]);

        scanner.close();
    }

    public static int minimum(int x, int y)
    {
        int result = INF;

        if (x == y)
        {
            return 0;
        }

        if (c[x][y] != 0)
        {
            return c[x][y];
        }

        for (int i = x; i < y; i++)
        {
            result = Math.min(result, minimum(x, i) + minimum(i + 1, y) + matrix[x][0] * matrix[i][1] * matrix[y][1]);
            c[x][y] = result;
        }

        return result;
    }
}