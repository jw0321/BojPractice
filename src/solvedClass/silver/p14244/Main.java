package solvedClass.silver.p14244;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");

        // 노드 갯수
        int n = Integer.parseInt(inputs[0]);
        // 리프 갯수
        int m = Integer.parseInt(inputs[1]);

        int[][] matrix = new int[n - 1][2];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        int a = 1, b = 2;
        int leaf = a;
        for (int i = 1; i < n - 1; i++) {
            matrix[i][0] = a;
            if (m > 1) {
                matrix[i][0] = leaf;
                m--;
            }
            matrix[i][1] = b;
            a++;
            b++;
        }
        for (int[] arr : matrix) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }
        System.out.println(sb);
    }
}
