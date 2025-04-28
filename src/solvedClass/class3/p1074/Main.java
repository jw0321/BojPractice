package solvedClass.class3.p1074;

import java.io.*;

public class Main {

    // 분할 정복 문제
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int x = 0;
        int y = 0;
        int count = 0;
        int size = (int) Math.pow(2, n);

        while (size > 1) {
            int newSize = size / 2;
            int quadrantSize = newSize * newSize;

            // 찾는 위치가 포함된 사분면을 찾는다.     12
            // 1사분면일때는 그냥 사이즈를 줄이면 된다. 34
            if (r < x + newSize && c >= y + newSize) {
                // 2사분면
                count += quadrantSize;
                y += newSize;
            } else if (r >= x + newSize && c < y + newSize) {
                // 3사분면
                count += 2 * quadrantSize;
                x += newSize;
            } else if (r >= x + newSize && c >= y + newSize) {
                // 4사분면
                count += 3 * quadrantSize;
                x += newSize;
                y += newSize;
            }

            size = newSize;
        }

        System.out.println(count);
    }

}
