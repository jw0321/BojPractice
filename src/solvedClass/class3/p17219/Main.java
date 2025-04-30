package solvedClass.class3.p17219;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] inputs2 = br.readLine().split(" ");
            map.put(inputs2[0], inputs2[1]);
        }
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            sb.append(map.get(input)).append('\n');
        }
        System.out.println(sb);
    }
}
