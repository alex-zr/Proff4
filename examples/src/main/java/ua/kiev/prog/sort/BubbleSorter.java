package ua.kiev.prog.sort;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class BubbleSorter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(9,6,3,8,2,5,9,5,2,1));
        bubbleSorter(list);
        System.out.println(list);


    }
    public static List<Integer> bubbleSorter(List<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size() - 1; j++) {
                if(list.get(j)>list.get(j+1)) {
                    int tmp = list.get(j+1);
                    list.set(j+1, list.get(j));
                    list.set(j, tmp);

                }
            }
        }
        return list;
    }
}
