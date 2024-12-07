package com.demo.basics.java._27_filediff;

import java.nio.file.Files;
import java.nio.file.Path;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FileDiff {

    @SneakyThrows
    @Test
    @Disabled
    public void test() {
        var first = Path.of("/tmp/1.txt");
        var second = Path.of("/tmp/2.txt");
        var firstByteDiff = Files.mismatch(first, second);
        if (firstByteDiff == -1) {
            System.out.println("Files Identical");
        } else {
            System.out.println("Files not identical");
        }
    }
}
