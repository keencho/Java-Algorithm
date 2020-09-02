package com.sycho.hackerrank.medium;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/cut-the-tree/problem?h_r=internal-search
public class CutTheTree {

    private static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        // Write your code here

        int t = 0;
        for (int a : data) {
            t += a;
            System.out.println("a equal: " + a);
        }

        System.out.println("total: " + t);
        System.out.println("---------------------");

        for (List<Integer> a : edges) {
            System.out.println(a);
        }

        for (List<Integer> a : edges) {
            List<List<Integer>> tmp = edges;
            tmp.remove(a);
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("/Users/gf-mac/Desktop/workspace/Java-Algorithm/algorithm/input/CutTheTree.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

