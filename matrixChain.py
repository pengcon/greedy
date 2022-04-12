import sys
input = sys.stdin.readline
matrix = []
print("입력값 N 입력")
n = int(input())
for _ in range(n):
    matrix.append(tuple(map(int, input().split())))

dp = [[0 for _ in range(n)] for _ in range(n)]

def calc(i, j): # i 번째 행렬부터 j 번째 행렬까지 연산하는 횟수. 즉 dp[i][j]의 값을 구하는 함수
    if dp[i][j] != 0:
        return dp[i][j]
    if i == j:
        return dp[i][j]
    if j - i == 1:
        dp[i][j] = matrix[i][0] * matrix[i][1] * matrix[j][1]
        return dp[i][j]

    answer = float("inf")
    for k in range(i, j):
        cmp = calc(i, k) + calc(k+1, j) + (matrix[i][0] * matrix[k][1] * matrix[j][1])
        answer = min(answer, cmp)

    dp[i][j] = answer
    return dp[i][j]


print(calc(0, n-1))