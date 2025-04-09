package solvedClass.class2.p11651;

import java.io.*;
import java.util.*;

public class Main {

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Coordinate[] coordinates = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            coordinates[i] = new Coordinate(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }

        Arrays.sort(coordinates, (o1, o2) -> {
            if (o1.y != o2.y) {
                return o1.y - o2.y;
            } else {
                return o1.x - o2.x;
            }
        });
        for (Coordinate coordinate : coordinates) {
            sb.append(coordinate);
        }
        System.out.println(sb);
    }
}
