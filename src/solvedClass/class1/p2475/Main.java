package solvedClass.class1.p2475;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split(" ");

        int result = 0;
        for (String s : arr) {
            int n = Integer.parseInt(s);
            result += (int) Math.pow(n, 2);
        }
        System.out.println(result % 10);
    }
}
