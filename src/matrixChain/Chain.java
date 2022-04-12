package matrixChain;
import java.util.Scanner;

public class Chain {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력값 N 입력: ");
        int N = scanner.nextInt();
        int [][] C = new int[501][501]; // 행렬 생성 (C1, C2, C3 ''')
        int [] D = new int [1001]; // 행렬 곱의 원소들 (D0, D1, D2 ''')

        // 행과 열의 수가 같은 경우 0으로 행렬 초기화
        for(int i = 0; i < N; i++)
            C[i][i] = 0;

        // 행렬 곱셈에 필요한 원소 입력 (D0, D1)
        for(int i = 0; i < N; i++){
            D[i] = scanner.nextInt(); // ex) D0
            D[i + 1] = scanner.nextInt(); // ex) D1
        }

        for(int L = 1; L < N; L++)  // L은 부분문제의 크기를 조절하는 인덱스
            for(int i = 1; i < N-L+1; i++){
                int j = i + L;
                C[i][j] = INF;
                for(int k = i; k < j; k++){
                    int temp = C[i][k] + C[k+1][j] + D[i - 1] * D[k] * D[j];
                    if(temp < C[i][j])
                        C[i][j] = temp;
                }
            }
        System.out.println(C[1][N]);
    }
}
