package solvedClass.class2.p14626;

import java.io.*;

public class Main {
    // 브루트 포스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] arr = new int[13];
        int index = -1;

        for (int i = 0; i < 13; i++) {
            if (input.charAt(i) != '*') {
                arr[i] = input.charAt(i) - '0';
            } else {
                arr[i] = -1;
                index = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < 13; i++) {
            if (arr[i] != -1) {
                if (i % 2 == 0) {
                    sum += arr[i];
                } else {
                    sum += arr[i] * 3;
                }
            }
        }

        int remainder = sum % 10;
        int result = -1;
        if (index % 2 == 0) {
            result = (10 - remainder) % 10;
        } else {
            int n = sum / 10;
            while (result % 3 != 0) {
                if (10 * n > sum) {
                    result = 10 * n - sum;
                }
                n++;
            }

            result = (result / 3) % 10;
        }

        System.out.println(result);
    }
}
