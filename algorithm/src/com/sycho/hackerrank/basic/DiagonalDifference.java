package com.sycho.hackerrank.basic;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int x = 0; x < arr.get(i).size(); x++) {
                result1 += i == x ? arr.get(i).get(x) : 0;
                result2 += i + x == arr.get(i).size() - 1 ? arr.get(i).get(x) : 0;
            }
        }

        return Math.abs(result1 - result2);
    }

}

class DiagonalDifferenceSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifference.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
