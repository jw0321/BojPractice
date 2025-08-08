package solvedClass.class4.p16953;

import java.io.*;
import java.util.*;

// BFS 문제
public class Main {

    static long a, b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        Queue<Long> queue = new ArrayDeque<>();
        queue.offer(a);
        Map<Long,Integer> map = new HashMap<>();
        map.put(a, 1);
        while (!queue.isEmpty()) {
            long curr = queue.poll();
            if (curr == b) {
                System.out.println(map.get(curr));
                return;
            }
            if (curr * 2 <= b) {
                queue.offer(curr * 2);
                map.put(curr * 2, map.get(curr) + 1);
            }
            if (curr * 10 + 1 <= b) {
                queue.offer(curr * 10 + 1);
                map.put(curr * 10 + 1, map.get(curr) + 1);
            }
        }
        System.out.println(-1);
    }
}
