package org.example;

import java.util.Random;

public class Main {
    static long comparisons = 0;
    static long swaps = 0;
    static long arrayAccesses = 0;

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swaps++;
        arrayAccesses += 4;
    }

    static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                comparisons++;
                arrayAccesses += 2;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex == i) {
                boolean sorted = true;

                for (int k = i; k < n - 1; k++) {
                    comparisons++;
                    arrayAccesses += 2;
                    if (array[k] > array[k + 1]) {
                        sorted = false;
                        break;
                    }
                }

                if (sorted) break;
            }

            swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) {

        int size = 1000;
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input size, using default (1000).");
            }
        }


        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10_000);
        }


        long startTime = System.nanoTime();
        selectionSort(arr);
        long endTime = System.nanoTime();


        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }


        System.out.println(sorted ? "✅ Array sorted successfully." : "❌ Array not sorted correctly.");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array accesses: " + arrayAccesses);
        System.out.printf("Time: %.3f ms%n", (endTime - startTime) / 1_000_000.0);

        MetricsExporter.exportToCSV("metrics.csv", size, comparisons, swaps, arrayAccesses, (endTime - startTime) / 1_000_000.0);

    }
}
