package solvedClass.class1.p2675;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] arr = input.split(" ");

            int repeat = Integer.parseInt(arr[0]);
            String s = arr[1];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                for (int k = 0; k < repeat; k++) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
