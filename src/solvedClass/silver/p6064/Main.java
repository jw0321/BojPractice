package solvedClass.silver.p6064;

import java.io.*;

public class Main {
    //브루트 포스 문제 - 정수론
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            if (m == n) {
                if (x == y) {
                    sb.append(x).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else {
                int k = x;
                int limit = m * n;

                boolean found = false;
                while (k <= limit) {
                    if ((k - 1) % n + 1 == y) {
                        sb.append(k).append('\n');
                        found = true;
                        break;
                    }
                    k += m;
                }

                if (!found) {
                    sb.append(-1).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
