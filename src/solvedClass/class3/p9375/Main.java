package solvedClass.class3.p9375;

import java.io.*;
import java.util.*;

public class Main {
    // map 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String cloth = input[1];

                if (map.containsKey(cloth)) {
                    map.put(cloth, map.get(cloth) + 1);
                } else {
                    map.put(cloth, 1);
                }
            }
            int ans = 1;
            for (int v : map.values()) {
                ans *= v + 1;
            }
            sb.append(ans - 1).append("\n");
        }
        System.out.println(sb);
    }
}
