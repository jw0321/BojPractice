package solvedClass.class3.p7662;

import java.io.*;
import java.util.*;

public class Main {

    // 트리 맵 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] inputs = br.readLine().split(" ");
                String calc = inputs[0];
                int num = Integer.parseInt(inputs[1]);

                // 삽입 연산
                if (calc.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    continue;
                }

                if (map.isEmpty()) {
                    continue;
                }

                // 삭제 연산
                int key = (num == 1) ? map.lastKey() : map.firstKey();
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
