package solvedClass.class1.p10869;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String[] arr = input.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        sb.append(a + b).append("\n");
        sb.append(a - b).append("\n");
        sb.append(a * b).append("\n");
        sb.append(a / b).append("\n");
        sb.append(a % b).append("\n");
        System.out.println(sb);
    }
}
