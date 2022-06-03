package com.demo.basics.java._11_fileops;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * https://nirajsonawane.github.io/page/6/
 */
public class FileOps {

    @SneakyThrows
    @Test
    public void test_writeFile() {
        Path fileName = Path.of("/tmp/test.txt");
        String content = "hello world !!";
        Files.writeString(fileName, content);
        String actual = Files.readString(fileName);
        System.out.println(actual);
    }

    @SneakyThrows
    @Test
    public void test_writeFileAppend() {
        Path fileName = Path.of("/tmp/test.txt");
        String content = "hello world !!";
        Files.writeString(fileName, content, StandardOpenOption.APPEND);
        String actual = Files.readString(fileName);
        System.out.println(actual);
    }

    @SneakyThrows
    @Test
    public void test_readFileLines() {
        String filePath = "src/test/resources/file.txt";
        //Read line by line
        List<String> readAllLines = Files.readAllLines(Paths.get((filePath)));
        readAllLines.forEach(System.out::println);
    }

    @SneakyThrows
    @Test
    public void test_readFileStream() {
        String filePath = "src/test/resources/file.txt";
        //Read line by line
        Stream<String> lines1 = Files.lines(Paths.get((filePath)), StandardCharsets.UTF_8);
        lines1.forEach(System.out::println);
    }

    @SneakyThrows
    @Test
    public void test_readFileString() {
        String filePath = "src/test/resources/file.txt";
        //Read file as single string.
        Stream<String> lines2 = Files.lines(Paths.get((filePath)));
        String fileAsString = lines2.collect(Collectors.joining());
        System.out.println(fileAsString);
    }

    @SneakyThrows
    @Test
    public void test_readFileBuffer() {
        String filePath = "src/test/resources/file.txt";
        //BufferReader read file
        BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
        reader.lines().forEach(System.out::println);
    }

    @SneakyThrows
    @Test
    public void test_readFileLineByLine() {
        String filePath = "src/test/resources/file.txt";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        }
    }

    @SneakyThrows
    @Test
    public void test_listDir() {
        //List All Files in Directory
        try (Stream<Path> list = Files.list(Paths.get("src/test/resources"));) {
            list.forEach(System.out::println);
        }
    }

    @SneakyThrows
    @Test
    public void test_listHiddenFiles() {
        //List hidden files
        try (Stream<Path> list = Files.list(Paths.get("src/test/resources"))) {
            List<String> fileList = list.filter(path -> path.toFile().isHidden())
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
            fileList.forEach(System.out::println);
        }
    }

    @SneakyThrows
    @Test
    public void test_listFiles() {
        //List files
        try (Stream<Path> list = Files.list(Paths.get("src/test/resources"))) {
            List<String> fileList = list.filter(path -> path.toFile().isFile())
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
            fileList.forEach(System.out::println);
        }
    }


    @SneakyThrows
    @Test
    public void test_listFilesStartingWith() {
        //List All Files in Directory Starting with m
        try (Stream<Path> list = Files.list(Paths.get("src/test/resources"))) {
            List<String> fileList = list.map(path -> path.getFileName().toString())
                    .filter(name -> name.startsWith("f"))
                    .sorted()
                    .collect(Collectors.toList());
            fileList.forEach(System.out::println);
        }
    }

    @SneakyThrows
    @Test
    public void test_listCurrDirFiles() {
        //List All Files in Current Directory only
        Path start = Paths.get("src/test/resources");
        try (Stream<Path> stream = Files.walk(start, 1)) {
            List<String> collect = stream
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        }
    }

    @SneakyThrows
    @Test
    public void test_listSubDirFiles() {
        //List All Files in Directory and Subdirectories
        Path path = Paths.get("src/test/resources");
        try (Stream<Path> stream = Files.walk(path, Integer.MAX_VALUE)) {
            List<String> collect = stream
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.toList());
            collect.forEach(System.out::println);
        }
    }

}
