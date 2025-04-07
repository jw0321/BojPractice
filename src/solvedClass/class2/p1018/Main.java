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
                String[] color = {"W", "B"};
                int[] colorCount = new int[2];
                for (int z = 0; z < 2; z++) {
                    String[][] colors = copyStringArray(inputColors);
                    if (!color[z].equals(colors[i][j])) {
                        colors[i][j] = color[z];
                        colorCount[z]++;
                    }
                    for (int k = i; k < i + 8; k++) {
                        for (int l = j + 1; l < j + 8; l++) {
                            if (colors[k][l - 1].equals(colors[k][l])) {
                                if(colors[k][l].equals("W")) {
                                    colors[k][l] = "B";
                                } else {
                                    colors[k][l] = "W";
                                }
                                colorCount[z]++;
                            }
                        }
                        if (k != i + 7 && colors[k][j].equals(colors[k + 1][j])) {
                            if(colors[k + 1][j].equals("W")) {
                                colors[k + 1][j] = "B";
                            } else {
                                colors[k + 1][j] = "W";
                            }
                            colorCount[z]++;
                        }
                    }
                }
                countArr[i][j] = Math.min(colorCount[0], colorCount[1]);
            }
        }
        int min = countArr[0][0];
        for (int[] intRow : countArr) {
            for (int num : intRow) {
                if (num < min) {
                    min = num;
                }
            }
        }
        System.out.println(min);
    }

    private static String[][] copyStringArray(String[][] strArr) {
        String[][] strArr2 = new String[strArr.length][strArr[0].length];
        for (int i = 0; i < strArr.length; i++) {
            for (int j = 0; j < strArr[i].length; j++) {
                strArr2[i][j] = strArr[i][j];
            }
        }
        return strArr2;
    }
}
