package io.github.skeffy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("src/main/resources/input.txt"))) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            while (in.hasNext()) {
                a.add(in.nextInt());
                b.add(in.nextInt());
            }

            System.out.println(compareLists(a, b));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file");
        }
    }

    public static int compareLists(List<Integer> a, List<Integer> b) {
        int listDifference = 0;

        Collections.sort(a);
        Collections.sort(b);

        for (int i = 0; i < a.size(); i++) {
            listDifference += Math.abs(a.get(i) - b.get(i));
        }

        return listDifference;
    }
}