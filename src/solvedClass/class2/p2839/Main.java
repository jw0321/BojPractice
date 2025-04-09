package solvedClass.class2.p2839;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = n / 5;
        int b = n / 3;

        int result = b + 1;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int sum = i * 5 + j * 3;
                if (sum == n) {
                    result = Math.min(result, i + j);
                }
            }
        }
        if (result > b) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }
}
