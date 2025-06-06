package solvedClass.class1.p2439;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - i - 1)).append("*".repeat(i + 1)).append('\n');
        }

        System.out.println(sb);
    }

}
