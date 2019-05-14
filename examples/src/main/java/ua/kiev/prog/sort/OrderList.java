package ua.kiev.prog.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(9,2,0,4,7,10,0,3));
        orderList(list);
        System.out.println(list);

    }
    public static List<Integer> orderList(List<Integer> list) {
        for(int i = 0; i< list.size(); i++) {
            int tmp = list.get(i);
            for(int j = i +1; j < list.size(); j++) {
                if (list.get(i) >= list.get(j)){
                    tmp = list.get(j);
                    list.remove(j);
                    list.add(i, tmp);
                }
            }
        }
        return list;
    }
}