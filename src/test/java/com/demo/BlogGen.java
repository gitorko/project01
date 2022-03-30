package com.demo;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class BlogGen {

    @SneakyThrows
    @Test
    public void generateBlog() {
        Map<String, Path> paths = new LinkedHashMap<>();
        paths.put("Sorting", Paths.get("src/test/java/com/demo/basics/sorting"));
        paths.put("Data Structure", Paths.get("src/test/java/com/demo/basics/datastructure"));
        paths.put("LeetCode - Easy", Paths.get("src/test/java/com/demo/leetcode/easy"));
        paths.put("LeetCode - Medium", Paths.get("src/test/java/com/demo/leetcode/medium"));
        paths.put("LeetCode - Hard", Paths.get("src/test/java/com/demo/leetcode/hard"));
        paths.put("Concurrency", Paths.get("src/test/java/com/demo/basics/concurrency"));
        System.out.println();
        String baseUrl = "https://github.com/gitorko/project01/tree/master/";
        for (Map.Entry<String, Path> map : paths.entrySet()) {
            System.out.println("## " + map.getKey());
            System.out.println();
            System.out.println("|Id   | Leetcode     | Solution        | Type        |");
            System.out.println("| --- | ---          | ---             | ---         |");
            String bookmark = map.getKey();
            bookmark = bookmark.toLowerCase();
            bookmark = bookmark.replaceAll("\\s+", "");
            try (Stream<Path> stream = Files.walk(map.getValue(), Integer.MAX_VALUE)) {
                List<String> files = stream
                        .map(String::valueOf)
                        .filter(f -> f.endsWith(".java"))
                        .sorted()
                        .collect(Collectors.toList());

                int counter = 1;
                for (String f : files) {
                    try (BufferedReader br = Files.newBufferedReader(Paths.get(f))) {
                        while (br.ready()) {
                            String line = br.readLine();
                            if (!line.startsWith(" *")) continue;
                            if (line.contains("youtube")) continue;
                            if (line.contains("TYPE")) continue;
                            if (line.contains("PRACTICE")) continue;
                            if (line.contains("lintcode")) continue;
                            if (line.startsWith(" */")) break;
                            if (line.startsWith("public")) break;
                            line = line.replaceAll("\\*", "").trim();
                            if (line.isBlank()) continue;

                            line = line.replaceAll("SIMILAR_TO:", "<font color='green'>Similar:</font>");
                            line = line.replaceAll("MEMORIZE", "<font color='red'>Memorize!</font>");

                            if (line.startsWith("[")) {
                                String problem = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
                                String url = line.substring(line.indexOf("("), line.indexOf(")") + 1);
                                String leetcode;
                                if (line.contains("()")) {
                                    leetcode = problem.substring(0, problem.lastIndexOf("-")).trim();
                                } else {
                                    leetcode = "[" + problem.substring(0, problem.lastIndexOf("-")).trim() + "]" + url;
                                }
                                String type = problem.substring(problem.lastIndexOf("-")).replaceAll("-", "").trim();
                                System.out.println(String.format("|%s|%s|%s|%s|", counter++, leetcode, "[Solution](" + baseUrl + f + ")", type));
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();

        Map<String, Path> readmePath = new LinkedHashMap<>();
        paths.put("SQL", Paths.get("src/test/java/com/demo/sql"));
        paths.put("System Design", Paths.get("src/test/java/com/demo/systemdesign"));
        for (Map.Entry<String, Path> readmePathMap : paths.entrySet()) {
            try (Stream<Path> stream = Files.walk(readmePathMap.getValue(), Integer.MAX_VALUE)) {
                List<String> files = stream
                        .map(String::valueOf)
                        .filter(f -> f.endsWith(".md"))
                        .sorted()
                        .collect(Collectors.toList());

                int counter = 1;
                for (String f : files) {
                    try (BufferedReader br = Files.newBufferedReader(Paths.get(f))) {
                        while (br.ready()) {
                            String line = br.readLine();
                            System.out.println(line);
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
