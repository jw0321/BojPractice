package solvedClass.class2.p2751;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }
        // 기본 제공하는 정렬은 비교 기반 정렬로 범위가 제한되어 있다면 계수 정렬을 사용하는 것도 좋다.
        Arrays.sort(inputs);
        for (int i : inputs) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
