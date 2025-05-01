package solvedClass.class3.p17626;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 브루트포스
//        int a, b, c, d;
//        for (int i = 0; i < 224; i++) {
//            for (int j = 0; j < 224; j++) {
//                for (int k = 0; k < 224; k++) {
//                    for (int l = 1; l < 224; l++) {
//                        a = l * l;
//                        b = a + k * k;
//                        c = b + j * j;
//                        d = c + i * i;
//                        if (a == n) {
//                            System.out.println("1");
//                            return;
//                        } else if (b == n) {
//                            System.out.println("2");
//                            return;
//                        }  else if (c == n) {
//                            System.out.println("3");
//                            return;
//                        }  else if (d == n) {
//                            System.out.println("4");
//                            return;
//                        }
//                    }
//                }
//            }
//        }

        // DP
        int[] arr = new int[50001];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, arr[i - j * j]);
            }
            arr[i] = min + 1;
        }
        System.out.println(arr[n]);
    }
}
