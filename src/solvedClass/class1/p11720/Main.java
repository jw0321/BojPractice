package solvedClass.class1.p11720;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        String[] arr = input.split("");
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(arr[i]);
        }
        sb.append(result);

        System.out.println(sb);
    }
}
