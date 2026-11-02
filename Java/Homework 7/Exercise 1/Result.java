package Homework7;

import java.util.List;

public record Result(List<String> path, int totalMinutes) {
    public static final Result Unreachable = new Result(List.of(), -1);
}
