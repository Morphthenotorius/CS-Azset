package Homework7;

import java.io.BufferedReader;
import java.io.IOException;

public class LineSource implements AutoCloseable{
    private final BufferedReader reader;
    private final int sourceIndex;
    private String currentLine;

    public LineSource(BufferedReader reader, int sourceIndex) throws IOException {
        this.reader = reader;
        this.sourceIndex = sourceIndex;
        advance();
    }

    public boolean advance() throws IOException {
        this.currentLine = reader.readLine();
        if (this.currentLine == null) {
            close();
            return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public String getCurrentLine() {
        return currentLine;
    }

    public int getSourceIndex() {
        return sourceIndex;
    }
}
