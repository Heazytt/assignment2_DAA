package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MetricsExporter {
    public static void exportToCSV(String filename, int size, long comparisons, long swaps, long arrayAccesses, double timeMs) {
        File file = new File(filename);
        boolean fileExists = file.exists();

        try (FileWriter writer = new FileWriter(file, true)) {

            if (!fileExists) {
                writer.write("size,comparisons,swaps,arrayAccesses,time_ms\n");
            }


            writer.write(size + "," + comparisons + "," + swaps + "," + arrayAccesses + "," + String.format("%.3f", timeMs) + "\n");
        } catch (IOException e) {
            System.err.println("❌ Failed to write CSV: " + e.getMessage());
        }
    }
}
