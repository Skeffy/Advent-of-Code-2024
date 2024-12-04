package io.github.skeffy;

import java.util.List;
import java.util.Stack;

public class Part2 {

    public static void main(String[] args) {
        Stack<List<Integer>> lists = Part1.parseLists();
        System.out.println(getSimilarityScore(lists));
    }

    public static int getSimilarityScore(Stack<List<Integer>> lists) {
        int similarityScore = 0;
        List<Integer> a = lists.pop();
        List<Integer> b = lists.pop();

        for (Integer num : a) {
            int numOfOccurences = 0;
            while (b.contains(num)) {
                b.remove(num);
                numOfOccurences++;
            }
            similarityScore += num * numOfOccurences;
        }

        return similarityScore;
    }
}
