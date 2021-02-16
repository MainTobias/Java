package com.euler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TriangleReader {
    public static int[][] read(String path) {
        List<int[]> triangle = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().strip();
                if (line.length() == 0) continue;
                triangle.add(Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray());
            }
            sc.close();
            return triangle.toArray(new int[triangle.size()][]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
