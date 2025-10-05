package org.example;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            long start = System.nanoTime();
            Main.selectionSort(arr);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("n = %d | time = %.2f ms%n", size, timeMs);
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10_000);
        }
        return arr;
    }
}
