package solvedClass.class1.p1152;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().strip().split(" ");
        if (arr.length == 1 && arr[0].equals("")) {
            System.out.println("0");
            return;
        }

        System.out.println(arr.length);
    }
}
