package solvedClass.class2.p2798;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs1 = br.readLine().split(" ");
        String[] inputs2 = br.readLine().split(" ");

        int n = Integer.parseInt(inputs1[0]);
        int m = Integer.parseInt(inputs1[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputs2[i]);
        }

        int maxSum = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum <= m && maxSum < sum) {
                        maxSum = sum;
                    }
                }
            }

        }
        System.out.println(maxSum);
    }
}
