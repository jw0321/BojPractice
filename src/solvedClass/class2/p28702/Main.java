package solvedClass.class2.p28702;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = new String[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = br.readLine();
        }

        int answer = 0;
        for (int j = 0; j < inputs.length; j++) {
            if (Character.isDigit(inputs[j].charAt(0))) {
                answer = Integer.parseInt(inputs[j]) + 3 - j;
            }
        }

        if (answer % 3 == 0 && answer % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (answer % 3 == 0) {
            System.out.println("Fizz");
        } else if (answer % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(answer);
        }
    }
}
