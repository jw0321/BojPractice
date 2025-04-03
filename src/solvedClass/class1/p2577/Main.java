package solvedClass.class1.p2577;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = (A * B * C) + "";
        char[] chars = result.toCharArray();

        for (int i = 0; i < 10; i++) {
            char ch = (char) ('0' + i);
            int count = 0;
            for (char c : chars) {
                if (c == ch) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
