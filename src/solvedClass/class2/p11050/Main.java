package solvedClass.class2.p11050;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        long result = factorial(n) / (factorial(k) * factorial(n - k));
        System.out.println(result);
    }


//    static int factorial(int n) {
//        if(n == 1) return 1;
//        return n * factorial(n - 1);
//    }

    // 자바에서는 재귀 함수 사용시 스택 오버플로우가 발생한다. 따라서 반복문으로 구현해야 한다.
    static long factorial (int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
