package solvedClass.class4.p11444;

import java.io.*;

// 분할 정복을 이용한 거듭제곱 문제
public class Main {

    static long[][] matrix = new long[][]{
            {1, 1},
            {1, 0}
    };
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long power = n - 1;
        long[][] result = new long[][]{
                {1, 0},
                {0, 1}
        };

        // 분할 정복을 이용한 거듭제곱
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrix(result, matrix);
            }
            power /= 2;
            matrix = multiplyMatrix(matrix, matrix);
        }

        System.out.println(result[0][0]);
    }

    // 행렬곱
    public static long[][] multiplyMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] result = new long[2][2];

        result[0][0] = ((matrix1[0][0] * matrix2[0][0]) % mod + (matrix1[0][1] * matrix2[1][0]) % mod) % mod;
        result[0][1] = ((matrix1[0][0] * matrix2[0][1]) % mod + (matrix1[0][1] * matrix2[1][1]) % mod) % mod;
        result[1][0] = ((matrix1[1][0] * matrix2[0][0]) % mod + (matrix1[1][1] * matrix2[1][0]) % mod) % mod;
        result[1][1] = ((matrix1[1][0] * matrix2[0][1]) % mod + (matrix1[1][1] * matrix2[1][1]) % mod) % mod;

        return result;
    }

}
