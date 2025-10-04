package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSelectionSortRandomArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr, "Массив должен быть отсортирован по возрастанию");
    }

    @Test
    void testSelectionSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Отсортированный массив не должен измениться");
    }

    @Test
    void testSelectionSortReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Массив в обратном порядке должен быть отсортирован");
    }

    @Test
    void testSelectionSortWithDuplicates() {
        int[] arr = {3, 1, 2, 1, 3};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr, "Массив с дубликатами должен быть отсортирован корректно");
    }

    @Test
    void testSelectionSortEmptyArray() {
        int[] arr = {};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{}, arr, "Пустой массив должен оставаться пустым");
    }

    @Test
    void testSelectionSortSingleElement() {
        int[] arr = {42};
        Main.selectionSort(arr);
        assertArrayEquals(new int[]{42}, arr, "Массив из одного элемента должен оставаться неизменным");
    }
}
