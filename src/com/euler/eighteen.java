package com.euler;

import java.util.Arrays;


public class eighteen {
    public static void main(String[] args) {
        int[][][] test = new int[][][]{{{3}}, {{7, 4}}, {{2, 4, 6}}, {{8, 5, 9, 3}}};
        greatestPathSum(test);
    }
    private static void greatestPathSum(int[][][] triangle){
        for (int i = triangle.length-2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = add(triangle[i][j][0], triangle[i+1][0]);
            }
        }
    }
    private static int[] add(int increase, int[]... lists) {
        int totalLength = 0;
        for (int i = 0; i < lists.length; i++) {
            totalLength += lists[i].length;
        }
        int[] out = new int[totalLength];
        int x = 0;
        int subFromLength = 0;
        for (int i = 0; i < out.length; i++) {
            if (i-subFromLength < lists[x].length) {
                out[i] = lists[x][i-subFromLength] + increase;
            } else {
                subFromLength += lists[x].length;
                x++;
            }
        }
        return out;
    }
}
/*old approach
public class eighteen {
    public static void main(String[] args) {
        int[][] triangle = new int[][]{{75}, {95, 64}, {17, 47, 82}, {18, 35, 87, 10}, {20, 4, 82, 47, 65}, {19, 1, 23, 75, 3, 34}, {88, 2, 77, 73, 7, 63, 67}, {99, 65, 4, 28, 6, 16, 70, 92}, {41, 41, 26, 56, 83, 40, 80, 70, 33}, {41, 48, 72, 33, 47, 32, 37, 16, 94, 29}, {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14}, {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57}, {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48}, {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31}, {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};
        //int[][] test = new int[][]{{3}, {7, 4}, {2, 4, 6}, {8, 5, 9, 3}};
        int[][] lookupByValue = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                lookupByValue[i] = orderBySize(triangle[i]);
            }
        }
        int biggestSum = 0;
        for (int i = 0; i < lookupByValue.length; i++) {
            int a = sumOfPath(i, indexOf(1, lookupByValue[i]), triangle) != -1 ? sumOfPath(i, indexOf(1, lookupByValue[i]), triangle) : sumOfPath(i, indexOf(0, lookupByValue[i]), triangle);
            if (a > biggestSum) {
                biggestSum = a;
            }
        }
        System.out.println(biggestSum);
    }

    private static int sumPathUp(int row, int index, int[][] triangle) {
        int sum = 0;
        for (int i = row; i - 1 >= 0; i--) {
            if (i - 1 > 0) {
                if (index < triangle[i - 1].length) {
                    if (index > 0 && triangle[i - 1][index] < triangle[i - 1][index - 1]) {
                        sum += triangle[i - 1][index - 1];
                        index--;
                    } else {
                        sum += triangle[i - 1][index];
                    }
                } else {
                    if (index < triangle[i - 1].length) {
                        sum += triangle[i - 1][index - 1];
                    } else {
                        index = triangle[i-1].length-1;
                        sum += triangle[i - 1][index];
                    }
                }
            } else {
                sum += triangle[0][0];
            }
        }
        return sum;
    }

    private static int sumPathDown(int row, int index, int[][] triangle) {
        int sum = 0;
        for (int i = row; i + 1 < triangle.length; i++) {
            if (i + 1 < triangle.length) {
                if (triangle[i + 1][index] < triangle[i + 1][index + 1]) {
                    sum += triangle[i + 1][index + 1];
                    index++;
                } else {
                    sum += triangle[i + 1][index];
                }
            } else {
                sum += Math.max(triangle[i][index], triangle[i][index + 1]);
            }
        }
        return sum;
    }

    private static int sumOfPath(int startRow, int index, int[][] triangle) {
        int sum = 0;
        sum += sumPathDown(startRow, index, triangle);
        sum += sumPathUp(startRow, index, triangle);
        sum += triangle[startRow][index];
        return sum;
    }

    private static int indexOf(int value, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (value == ints[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int[] orderBySize(int[] ints) {
        Integer[] temp = Arrays.stream(ints).boxed().toArray(Integer[]::new);
        int[] out = new int[ints.length];
        for (int i = 0; i < temp.length; i++) {
            Integer biggestNum = null;
            Integer biggestNumIndex = null;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == null) {
                    continue;
                }
                if (biggestNum == null || temp[j] > biggestNum) {
                    biggestNumIndex = j;
                    biggestNum = ints[j];
                }
            }
            out[i] = biggestNumIndex;
            temp[biggestNumIndex] = null;
        }
        return out;
    }
}
*/