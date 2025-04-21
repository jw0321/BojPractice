package solvedClass.class3.p11723;

import java.io.*;
import java.util.*;

public class Main {

    // 비트 마스킹 문제 int 기준 32개, long 기준 64개의 정수 원소까지 표현 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().strip().split(" ");

            if (input[0].equals("add")) {
                set.add(Integer.parseInt(input[1]));
            } else if (input[0].equals("remove")) {
                set.remove(Integer.parseInt(input[1]));
            } else if (input[0].equals("check")) {
                if (set.contains(Integer.parseInt(input[1]))) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (input[0].equals("toggle")) {
                if (set.contains(Integer.parseInt(input[1]))) {
                    set.remove(Integer.parseInt(input[1]));
                } else {
                    set.add(Integer.parseInt(input[1]));
                }
            } else if (input[0].equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (input[0].equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}