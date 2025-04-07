package solvedClass.class2.p1018;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[][] inputColors = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputs2 = br.readLine().split("");
            System.arraycopy(inputs2, 0, inputColors[i], 0, m);
        }

        int[][] countArr = new int[n - 7][m - 7];
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                String[][] copyArr = copyColors(inputColors, i, j);
                countArr[i][j] = countColors(copyArr);
            }
        }

        int answer = countArr[0][0];
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i].length; j++) {
                if (countArr[i][j] < answer) {
                    answer = countArr[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    static int countColors(String[][] colors) {
        int countB = 0;
        int countW = 0;
        String[] manualColorsB = new String[colors.length];
        String[] manualColorsW = new String[colors.length];
        for (int i = 0; i < colors.length; i++) {
            manualColorsB[i] = i % 2 == 0 ? "B" : "W";
            manualColorsW[i] = i % 2 == 0 ? "W" : "B";
        }
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                if (i % 2 == 0 && !manualColorsB[j].equals(colors[i][j])) {
                    countB++;
                } else if (i % 2 != 0 && !manualColorsW[j].equals(colors[i][j])) {
                    countB++;
                }
            }
        }
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                if (i % 2 == 0 && !manualColorsW[j].equals(colors[i][j])) {
                    countW++;
                } else if (i % 2 != 0 && !manualColorsB[j].equals(colors[i][j])) {
                    countW++;
                }
            }
        }

        return Math.min(countB, countW);
    }

    static String[][] copyColors(String[][] colors, int x, int y) {
        String[][] copy = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy[i][j] = colors[x + i][y + j];
            }
        }
        return copy;
    }
}
