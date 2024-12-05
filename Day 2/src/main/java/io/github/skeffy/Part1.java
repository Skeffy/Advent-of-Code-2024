package io.github.skeffy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        System.out.println(getNumOfSafeReports(parseReports()));
    }

    public static List<String> parseReports() {
        List<String> reports = new ArrayList<>();

        try (Scanner in = new Scanner(new File("src/main/resources/input.txt"))) {
            while (in.hasNext()) {
                reports.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("unable to open file");
        }

        return reports;
    }

    public static int getNumOfSafeReports(List<String> reports) {
        int numOfSafeReports = 0;

        for (String line : reports) {
            int[] report = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int currentNum = report[0];
            boolean isIncreasing = false;
            System.out.println(Arrays.toString(report));
            for (int i = 1; i < report.length; i++) {
                if (report[i] == currentNum || report[i] < currentNum - 3 || report[i] > currentNum + 3) {
                    break;
                }
                if (i == 1 && report[i] > currentNum) {
                    isIncreasing = true;
                }
                if (isIncreasing && report[i] > currentNum) {
                    currentNum = report[i];
                } else if (!isIncreasing && report[i] < currentNum) {
                    currentNum = report[i];
                } else {
                    break;
                }
                if (i == report.length - 1) {
                    numOfSafeReports++;
                    isIncreasing = false;
                }
            }
        }

        return numOfSafeReports;
    }
}