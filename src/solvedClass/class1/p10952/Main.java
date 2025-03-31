package solvedClass.class1.p10952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

            if (a == 0 && b == 0) {
                break;
            }

            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}
