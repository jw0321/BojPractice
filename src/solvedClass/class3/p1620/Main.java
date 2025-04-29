package solvedClass.class3.p1620;

import java.io.*;
import java.util.*;

public class Main {
    // 맵 자료구조
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            map1.put(i, input);
            map2.put(input, i);
        }
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                sb.append(map1.get(Integer.parseInt(input))).append('\n');
            } else {
                sb.append(map2.get(input)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
