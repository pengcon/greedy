import java.util.Scanner;
public class chained_matrix_multiplications {
    static int[][] matrix;                                  //���
    static int[][] c;                                       //����Ƚ��
    static int n;                                           //���ϴ� ����� ����

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("���� ����� ������ �Է� : ");
        n = scanner.nextInt();
        matrix = new int[n][2];                             //n��° a BY b ����϶� matrix[n][0]=a, matrix[n][1]=b
        c = new int[n][n];

        System.out.println("�� ����� ũ�⸦ �Է�");
        for (int i = 0; i < n; i++)
        {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        minimum(0, n - 1);                              //����Ƚ���� �ּڰ� ����
        System.out.println("����Ƚ���� �ּڰ��� : " + c[0][n - 1]);

        scanner.close();
    }

    public static int minimum(int x, int y)
    {
        int result = 201901687;                                 //�ּڰ��� �ʱ�ȭ

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