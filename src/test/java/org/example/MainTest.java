package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testSelectionSortBasic() {
        int[] arr = {5, 2, 8, 1, 3};
        int[] expected = {1, 2, 3, 5, 8};

        Main.selectionSort(arr);

        assertArrayEquals(expected, arr, "Array should be sorted in ascending order");
    }

    @Test
    public void testSelectionSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        Main.selectionSort(arr);

        assertArrayEquals(expected, arr, "Already sorted array should remain unchanged");
    }

    @Test
    public void testSelectionSortReverseOrder() {
        int[] arr = {9, 7, 5, 3, 1};
        int[] expected = {1, 3, 5, 7, 9};

        Main.selectionSort(arr);

        assertArrayEquals(expected, arr, "Reverse sorted array should be sorted correctly");
    }

    @Test
    public void testSelectionSortWithDuplicates() {
        int[] arr = {4, 2, 4, 1, 3};
        int[] expected = {1, 2, 3, 4, 4};

        Main.selectionSort(arr);

        assertArrayEquals(expected, arr, "Array with duplicates should be sorted correctly");
    }

    @Test
    public void testSelectionSortSingleElement() {
        int[] arr = {42};
        int[] expected = {42};

        Main.selectionSort(arr);

        assertArrayEquals(expected, arr, "Single element array should remain unchanged");
    }

    @Test
    public void testSelectionSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        Main.selectionSort(arr);

        assertArrayEquals(expected, arr, "Empty array should remain unchanged");
    }
}
