package solvedClass.class2.p1676;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 0의 개수는 10의 배수로 만들어 진다.
        // 10은 2와 5의 곱이지만 5보다 2의 갯수가 훨씬 많으므로 5의 개수만 세도 값을 구할 수 있다.
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 125 == 0) {
                count += 3;
            } else if (i % 25 == 0) {
                count += 2;
            } else if (i % 5 == 0) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
