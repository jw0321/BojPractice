package solvedClass.class3.p9095;

import java.io.*;

public class Main {
    // DP로 해결하는 방법
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // n은 10 이하의 양수
        int[] arr = new int[11];

        // 초기값
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int j = 4; j < 11; j++){
            // 점화식
            arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}