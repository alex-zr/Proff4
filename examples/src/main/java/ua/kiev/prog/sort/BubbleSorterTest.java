package ua.kiev.prog.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSorterTest {
    public static void main(String[] args) {
        BubbleSorterTest bubbleSorterTest = new BubbleSorterTest();
        bubbleSorterTest.testBubbleSorterSorted();
        bubbleSorterTest.testBubbleSorterRevert();
        bubbleSorterTest.testBubbleSorterSingle();
        bubbleSorterTest.testBubbleSorterEmpty();
    }

    public void testBubbleSorterSorted() {
        List<Integer> resList = BubbleSorter.bubbleSorter(new ArrayList<>(Arrays.asList(1, 2, 3)));

        System.out.println(resList.equals(Arrays.asList(1,2,3)));
    }

    public void testBubbleSorterRevert() {
        List<Integer> resList = BubbleSorter.bubbleSorter(new ArrayList<>(Arrays.asList(3, 2, 1)));

        List<Integer> expected = Arrays.asList(1, 2, 3);

        System.out.println(resList.equals(expected));
    }

    public void testBubbleSorterSingle() {
        List<Integer> resList = BubbleSorter.bubbleSorter(new ArrayList<>(Arrays.asList()));

        List<Integer> expected = Arrays.asList();

        System.out.println(resList.equals(expected));
    }

    public void testBubbleSorterEmpty() {
        List<Integer> resList = BubbleSorter.bubbleSorter(new ArrayList<>(Arrays.asList(3)));

        List<Integer> expected = Arrays.asList(3);

        System.out.println(resList.equals(expected));
    }
}
