package solvedClass.class3.p11659;

import java.io.*;

public class Main {
    // 누적합 알고리즘
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];
        String[] inputs2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs2[i]);
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int k = 0; k < m; k++) {
            String[] inputs3 = br.readLine().split(" ");
            int i = Integer.parseInt(inputs3[0]) - 1;
            int j = Integer.parseInt(inputs3[1]) - 1;

            int sum;
            if (i == 0) {
                sum = prefixSum[j];
            } else {
                sum = prefixSum[j] - prefixSum[i - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
