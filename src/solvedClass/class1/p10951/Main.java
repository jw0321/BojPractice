package solvedClass.class1.p10951;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            String[] arr = input.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}
