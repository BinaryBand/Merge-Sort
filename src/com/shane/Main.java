package com.shane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<Integer> mergeSort(List<Integer> unsortedList) {

        // Split the unsortedList list into two lists
        int middle = unsortedList.size() / 2;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < unsortedList.size(); i++) {
            if (i < middle) {
                list1.add(unsortedList.get(i));
            }
            else {
                list2.add(unsortedList.get(i));
            }
        }

        if (list1.size() > 1)
            list1 = mergeSort(list1);

        if (list2.size() > 1)
            list2 = mergeSort(list2);

        int j = 0;
        int k = 0;
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < list1.size() + list2.size(); i++) {
            if (k >= list2.size() || (j < list1.size() && list1.get(j) < list2.get(k))) {
                sortedList.add(list1.get(j));
                j++;
            }
            else {
                sortedList.add(list2.get(k));
                k++;
            }
        }

        return sortedList;

    }

    public static void main(String[] args) {

        List<Integer> unsortedList = Arrays.asList(7, 3, 5, 1, 10, 2, 9, 8, 4, 6);
        List<Integer> sortedList = mergeSort(unsortedList);

        System.out.println(unsortedList);
        System.out.println(sortedList);

    }
}
