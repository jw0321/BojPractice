package solvedClass.class2.p1920;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        nums = Arrays.stream(nums).sorted().toArray();

        int m = Integer.parseInt(br.readLine());
        String[] inputs2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int inputNum = Integer.parseInt(inputs2[i]);

            // 내장된 이진탐색 메서드 활용
            int result = Arrays.binarySearch(nums, inputNum);
            if (result >= 0) {
                sb.append("1").append('\n');
            } else {
                sb.append("0").append('\n');
            }
        }
        System.out.println(sb);
    }
}
