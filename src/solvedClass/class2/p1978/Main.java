package solvedClass.class2.p1978;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        // 하드 코딩으로 푼 것
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(inputs[i]);
//        }
//
//        // 소수 찾기 - 에라스토테네스의 체
//        // 조건 : 1000 이하의 자연수
//        // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 를 제외한 배수들을 제거하면 소수 판별 가능
//        int count = 0;
//        for (int i : arr) {
//            if (i == 1) {
//                continue;
//            } else if (i != 2 && i % 2 == 0) {
//                continue;
//            } else if (i != 3 && i % 3 == 0) {
//                continue;
//            } else if (i != 5 && i % 5 == 0) {
//                continue;
//            } else if (i != 7 && i % 7 == 0) {
//                continue;
//            } else if (i != 11 && i % 11 == 0) {
//                continue;
//            } else if (i != 13 && i % 13 == 0) {
//                continue;
//            } else if (i != 17 && i % 17 == 0) {
//                continue;
//            } else if (i != 19 && i % 19 == 0) {
//                continue;
//            } else if (i != 23 && i % 23 == 0) {
//                continue;
//            } else if (i != 29 && i % 29 == 0) {
//                continue;
//            } else if (i != 31 && i % 31 == 0) {
//                continue;
//            }
//            count++;
//        }

        // 다른 사람의 풀이를 보고 고친 것
        int count = 0;
        // 모든 약수 쌍 중 적어도 한 값은 숫자의 제곱근 이하에 있기 때문에 제곱근 이상의 값을 검사할 필요가 없다.
        for (String s : inputs) {
            if (isPrime(Integer.parseInt(s))) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
