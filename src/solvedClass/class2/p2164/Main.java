package solvedClass.class2.p2164;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 자바 큐 자료구조 활용하여 큐 생성
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 큐의 사이즈가 1이 될 때까지 수행
        while (queue.size() > 1) {
            // 맨 앞 카드를 버림
            queue.poll();
            // 다음 카드를 맨 뒤로 이동
            queue.offer(queue.poll());
        }

        System.out.println(queue.peek());
    }
}
