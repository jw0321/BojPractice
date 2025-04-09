package solvedClass.class2.p7568;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (arr[i][0] < arr[k][0] && arr[i][1] < arr[k][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}
