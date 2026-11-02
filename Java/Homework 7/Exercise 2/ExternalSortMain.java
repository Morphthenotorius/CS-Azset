package Homework7;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExternalSortMain {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java ExternalSortMain <input> <output> <tmpDir>");
            return;
        }

        Path in = Paths.get(args[0]);
        Path out = Paths.get(args[1]);
        Path tmpDir = Paths.get(args[2]);

        long startTime = System.currentTimeMillis();

        try {
            ExternalSort sorter = new ExternalSort();
            sorter.sort(in, out, tmpDir);

            long totalLines = ExternalSort.countLines(out);
            long elapsedTime = System.currentTimeMillis() - startTime;

            System.out.println("Sorted " + totalLines + " lines (" + elapsedTime + " ms).");

        } catch (Exception e) {
            System.err.println("Error during external sort: " + e.getMessage());
        }
    }
}
