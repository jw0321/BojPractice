package solvedClass.class3.p1931;

import java.io.*;
import java.util.*;


public class Main {

    // 그리디
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(inputs[0]);
            matrix[i][1] = Integer.parseInt(inputs[1]);
        }

        // 회의시간이 짧으면서 끝나는 시간 이상인 부분?
        // 종료 시간 순 정렬, 종료 시간이 같을 경우 시작 시간 순 정렬
        Arrays.sort(matrix, (a1, a2) -> {
            if (a1[1] == a2[1]) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        });

        int lastEndTime = -1;
        int count = 0;

        // 가장 일찍 끝나는 회의 선택 -> 시작시간이 종료 시간 이후면서 가장 일찍 끝나는 회의 선택
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] >= lastEndTime) {
                count++;
                lastEndTime = matrix[i][1];
            }
        }
        System.out.println(count);
    }
}

