package solvedClass.class1.p31403;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result1 = a + b - c;
        sb.append(result1).append("\n");

        String number = a + "" + b;
        int result2 = Integer.parseInt(number) - c;
        sb.append(result2);
        System.out.println(sb);
    }
}
