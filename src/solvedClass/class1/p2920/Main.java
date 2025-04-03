package solvedClass.class1.p2920;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        boolean inc = false;
        boolean dec = false;

        int before = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            if (n > before) {
                inc = true;
            } else {
                dec = true;
            }
            before = n;
        }
        if (inc && dec) {
            System.out.println("mixed");
        } else if (inc) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}
