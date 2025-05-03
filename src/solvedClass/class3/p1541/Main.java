package solvedClass.class3.p1541;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int numStart = 0;
        int index = 0;
        String[] stringArr = new String[50];
        char[] charArr = new char[50];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+') {
                stringArr[index] = input.substring(numStart, i);
                charArr[index] = input.charAt(i);
                index++;
                numStart = i + 1;
            } else if (i == input.length() - 1) {
                stringArr[index] = input.substring(numStart, i + 1);
            }
        }
        int count = 0;
        int sum = Integer.parseInt(stringArr[0]);
        boolean minus = false;
        while (count < index) {
            if (charArr[count] == '-' && !minus) {
                minus = true;
            }

            if (minus) {
                sum -= Integer.parseInt(stringArr[count + 1]);
            } else {
                sum += Integer.parseInt(stringArr[count + 1]);
            }
            count++;
        }
        System.out.println(sum);
    }
}
