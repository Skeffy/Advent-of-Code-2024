package io.github.skeffy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part1 {
    public static void main(String[] args) {
        System.out.println(compareLists(parseLists()));
    }

    public static Stack<List<Integer>> parseLists() {
        Stack<List<Integer>> lists = new Stack<>();

        try (Scanner in = new Scanner(new File("src/main/resources/input.txt"))) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            while (in.hasNext()) {
                a.add(in.nextInt());
                b.add(in.nextInt());
            }

            Collections.sort(a);
            Collections.sort(b);

            lists.push(b);
            lists.push(a);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file");
        }
        return lists;
    }

    public static int compareLists(Stack<List<Integer>> lists) {
        int listDifference = 0;
        List<Integer> a = lists.pop();
        List<Integer> b = lists.pop();

        for (int i = 0; i < a.size(); i++) {
            listDifference += Math.abs(a.get(i) - b.get(i));
        }

        return listDifference;
    }
}