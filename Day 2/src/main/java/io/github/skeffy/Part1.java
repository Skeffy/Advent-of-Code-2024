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

    public static List<List<Integer>> parseReports() {
        List<List<Integer>> reports = new ArrayList<>();

        try (Scanner in = new Scanner(new File("src/main/resources/input.txt"))) {
            while (in.hasNext()) {
                int[] reportAsArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                List<Integer> report = new ArrayList<>();
                for (int num : reportAsArray) {
                    report.add(num);
                }
                reports.add(report);
            }
        } catch (FileNotFoundException e) {
            System.out.println("unable to open file");
        }

        return reports;
    }

    public static int getNumOfSafeReports(List<List<Integer>> reports) {
        int numOfSafeReports = 0;

        for (List<Integer> report : reports) {
            if (isReportSafe(report)) {
                numOfSafeReports++;
            }
        }

        return numOfSafeReports;
    }

    public static boolean isReportSafe(List<Integer> report) {
        boolean isSafe = false;
        int currentNum = report.getFirst();
        boolean isIncreasing = false;
        System.out.println(report);
        for (int i = 1; i < report.size(); i++) {
            if (report.get(i) == currentNum || report.get(i) < currentNum - 3 || report.get(i) > currentNum + 3) {
                break;
            }
            if (i == 1 && report.get(i) > currentNum) {
                isIncreasing = true;
            }
            if (isIncreasing && report.get(i) > currentNum) {
                currentNum = report.get(i);
            } else if (!isIncreasing && report.get(i) < currentNum) {
                currentNum = report.get(i);
            } else {
                break;
            }
            if (i == report.size() - 1) {
                isSafe = true;
            }
        }
        return isSafe;
    }
}