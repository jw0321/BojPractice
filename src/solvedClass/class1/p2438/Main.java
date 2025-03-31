package solvedClass.class1.p2438;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("*".repeat(i));
            System.out.println(sb);
        }
    }
}
