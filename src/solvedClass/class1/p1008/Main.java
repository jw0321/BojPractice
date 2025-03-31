package solvedClass.class1.p1008;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String inputString = br.readLine();
        String[] inputStringArray = inputString.split(" ");

        int a = Integer.parseInt(inputStringArray[0]);
        int b = Integer.parseInt(inputStringArray[1]);

        double result = (double) a / b;
        sb.append(result);

        System.out.println(sb);
    }
}
