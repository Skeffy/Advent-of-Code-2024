package io.github.skeffy;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) {
        System.out.println(getNumOfSafeReports(Part1.parseReports()));
    }

    public static int getNumOfSafeReports(List<List<Integer>> reports) {
        int numOfSafeReports = 0;

        for(List<Integer> report : reports) {
            if (Part1.isReportSafe(report)) {
                numOfSafeReports++;
            } else {
                for (int i = 0; i < report.size(); i++) {
                    List<Integer> modifiedReport = new ArrayList<>(report);
                    modifiedReport.remove(i);
                    if (Part1.isReportSafe(modifiedReport)) {
                        numOfSafeReports++;
                        break;
                    }
                }
            }
        }
        return numOfSafeReports;
    }
}
