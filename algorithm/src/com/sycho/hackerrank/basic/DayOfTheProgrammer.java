package com.sycho.hackerrank.basic;
import java.io.*;

// https://www.hackerrank.com/challenges/day-of-the-programmer/problem
public class DayOfTheProgrammer {
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        int feb = 28;
        if (year % 4 == 0 || (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            feb = 29;
        }

        feb += 215;

        int a = 256 - feb;
        String result = Integer.toString(a).length() == 1 ? "0" + a : Integer.toString(a);

        return result + ".09." + year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
