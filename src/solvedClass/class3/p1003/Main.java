package solvedClass.class3.p1003;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int num = 0;
            int[][] matrix = new int[n + 1][2];
            while (num <= n) {
                if (num == 0) {
                    matrix[num][0] = 1;
                    matrix[num][1] = 0;
                } else if (num == 1) {
                    matrix[num][0] = 0;
                    matrix[num][1] = 1;
                } else{
                    matrix[num][0] = matrix[num - 1][0] + matrix[num - 2][0];
                    matrix[num][1] = matrix[num - 1][1] + matrix[num - 2][1];
                }
                num++;
            }

            sb.append(matrix[n][0]).append(" ").append(matrix[n][1]).append("\n");
        }
        System.out.println(sb);
    }

}
