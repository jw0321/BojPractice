package solvedClass.class4.p1629;

import java.io.*;

// 분할 정복을 이용한 거듭제곱 문제
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long num = Integer.parseInt(arr[0]);
        long power = Integer.parseInt(arr[1]);
        long mod = Integer.parseInt(arr[2]);

        long result = 1L;

        num %= mod;

        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * num) % mod;
            }
            power /= 2;
            num = (num * num) % mod;
        }
        System.out.print(result);
    }
}
