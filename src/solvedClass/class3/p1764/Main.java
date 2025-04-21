package solvedClass.class3.p1764;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set1.add(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);

        String[] arr = set1.toArray(new String[0]);
        Arrays.sort(arr);
        for (String s : arr) {
            sb.append(s).append('\n');
        }
        System.out.println(set1.size());
        System.out.println(sb);
    }
}
