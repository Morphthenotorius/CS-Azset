package Homework7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ExternalSort {
    public static final int CHUNK_LINES = 100_000;
    public static final int BATCH_SIZE = 10_000;

    public void sort(Path in, Path out, Path tmpDir) throws IOException {
        if (!Files.exists(tmpDir)) {
            Files.createDirectories(tmpDir);
        }

        List<Path> chunks = splitIntoSortedChunks(in, tmpDir);
        try {
            boolean hasTrailingNewline = checkTrailingNewline(in);
            kWayMerge(chunks, out, hasTrailingNewline);
        } finally {
            for (Path chunk : chunks) {
                Files.deleteIfExists(chunk);
            }
        }
    }

    public List<Path> splitIntoSortedChunks(Path in, Path tmpDir) throws IOException {
        List<Path> chunks = new ArrayList<>();
        if (!Files.exists(in) || Files.size(in) == 0) {
            return chunks;
        }

        try (BufferedReader reader = Files.newBufferedReader(in, StandardCharsets.UTF_8)) {
            List<String> buffer = new ArrayList<>(CHUNK_LINES);
            String line;
            int chunkIndex = 1;

            while ((line = reader.readLine()) != null) {
                buffer.add(line);
                if (buffer.size() == CHUNK_LINES) {
                    chunks.add(writeChunk(buffer, tmpDir, chunkIndex++));
                    buffer.clear();
                }
            }

            if (!buffer.isEmpty()) {
                chunks.add(writeChunk(buffer, tmpDir, chunkIndex));
                buffer.clear();
            }
        }

        return chunks;
    }

    private Path writeChunk(List<String> buffer, Path tmpDir, int index) throws IOException {
        Collections.sort(buffer);
        Path chunkPath = tmpDir.resolve(String.format("chunk-%04d.txt", index));
        try (BufferedWriter writer = Files.newBufferedWriter(chunkPath, StandardCharsets.UTF_8)) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (String s : buffer) {
                sb.append(s).append(System.lineSeparator());
                count++;
                if (count % BATCH_SIZE == 0) {
                    writer.write(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                writer.write(sb.toString());
            }
        }
        return chunkPath;
    }

    public void kWayMerge(List<Path> chunks, Path out) throws IOException {
        kWayMerge(chunks, out, true);
    }

    private void kWayMerge(List<Path> chunks, Path out, boolean hasTrailingNewline) throws IOException {
        if (chunks.isEmpty()) {
            if (Files.exists(out)) {
                Files.delete(out);
            }
            Files.createFile(out);
            return;
        }

        Comparator<LineSource> comparator = (a, b) -> {
            int cmp = a.getCurrentLine().compareTo(b.getCurrentLine());
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(a.getSourceIndex(), b.getSourceIndex());
        };

        PriorityQueue<LineSource> pq = new PriorityQueue<>(comparator);
        List<LineSource> sources = new ArrayList<>();

        try {
            for (int i = 0; i < chunks.size(); i++) {
                BufferedReader reader = Files.newBufferedReader(chunks.get(i), StandardCharsets.UTF_8);
                LineSource source = new LineSource(reader, i);
                if (source.getCurrentLine() != null) {
                    sources.add(source);
                    pq.add(source);
                } else {
                    source.close();
                }
            }

            try (BufferedWriter writer = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                boolean firstLine = true;

                while (!pq.isEmpty()) {
                    LineSource smallest = pq.poll();
                    String line = smallest.getCurrentLine();

                    if (!hasTrailingNewline) {
                        if (!firstLine) {
                            sb.append(System.lineSeparator());
                        } else {
                            firstLine = false;
                        }
                        sb.append(line);
                    } else {
                        sb.append(line).append(System.lineSeparator());
                    }

                    count++;
                    if (count % BATCH_SIZE == 0) {
                        writer.write(sb.toString());
                        sb.setLength(0);
                    }

                    if (smallest.advance()) {
                        pq.add(smallest);
                    }
                }

                if (sb.length() > 0) {
                    writer.write(sb.toString());
                }
            }
        } finally {
            for (LineSource source : sources) {
                try {
                    source.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private boolean checkTrailingNewline(Path in) throws IOException {
        if (!Files.exists(in) || Files.size(in) == 0) {
            return false;
        }
        try (java.io.RandomAccessFile raf = new java.io.RandomAccessFile(in.toFile(), "r")) {
            long length = raf.length();
            if (length == 0) {
                return false;
            }
            raf.seek(length - 1);
            byte lastByte = raf.readByte();
            return lastByte == '\n' || lastByte == '\r';
        }
    }

    public static long countLines(Path path) throws IOException {
        if (!Files.exists(path) || Files.size(path) == 0) {
            return 0;
        }
        long count = 0;
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }
}
