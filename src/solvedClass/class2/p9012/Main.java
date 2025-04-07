package solvedClass.class2.p9012;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 스택? 과 관련되어 있어 보임
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            int count = 0;
            for (String s : inputs) {
                if (s.equals("(")) {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    break;
                }
            }
            if (count == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
