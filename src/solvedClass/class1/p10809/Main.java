package solvedClass.class1.p10809;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for (int i = 'a'; i <= 'z'; i++) {
            int index = input.indexOf(i);

            if (index != -1) {
                sb.append(index).append(" ");
            } else {
                sb.append("-1").append(" ");
            }
        }

        System.out.println(sb);
    }
}
