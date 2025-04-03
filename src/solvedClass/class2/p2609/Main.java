package solvedClass.class2.p2609;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);


        // 하드 코딩
//        int min = Math.min(a, b);
//        int gcd = 1;
//        for (int i = gcd; i <= min; i++) {
//            if (a % i == 0 && b % i == 0) {
//                gcd = i;
//            }
//        }

        int gcd = euclidean(a, b);
        int lcm = (a * b) / gcd;

        sb.append(gcd).append("\n").append(lcm);
        System.out.println(sb);
    }

    // 유클리드 호제법 사용
    static int euclidean(int a, int b) {
        if (b == 0) {
            return a;
        }
        return euclidean(b, a % b);
    }

}
