package solvedClass.class2.p2231;

import java.io.*;

public class Main {

    // 초기 풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int target = Integer.parseInt(br.readLine());
//
//        int max = 1000000;
//        for (int i = 1; i <= max; i++) {
//            String[] arr = String.valueOf(i).split("");
//            int sum = 0;
//            for (int j = 0; j < arr.length; j++) {
//                sum += Integer.parseInt(arr[j]) * (int) Math.pow(10, arr.length - j - 1);
//                sum += Integer.parseInt(arr[j]);
//            }
//            if (sum == target) {
//                for (String s : arr) {
//                    sb.append(s);
//                }
//                break;
//            } else if (i == max) {
//                sb.append("0");
//            }
//        }
//        System.out.println(sb);
//    }

    // 알고리즘 분류를 본 후 풀이
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input = br.readLine();
       int n = Integer.parseInt(input);

       int answer = 0;

       // 자릿수의 최대 기여는 9이므로 (9 * 숫자의 길이) 만큼 뺀 부분에서 시작해야 한다.
       int start = Math.max(n - (input.length() * 9), 1);

       // 완전 탐색
       for (int i = start; i < n; i++) {
           int sum = 0;
           int temp = i;
           while (temp > 0) {
               sum += temp % 10;
               temp /= 10;
           }
           if (i + sum == n) {
               answer = i;
               break;
           }
       }
       System.out.println(answer);
    }
}
