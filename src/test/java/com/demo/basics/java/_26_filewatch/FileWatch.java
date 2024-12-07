package com.demo.basics.java._26_filewatch;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FileWatch {

    @SneakyThrows
    @Test
    @Disabled
    public void test() {
        Files.createTempDirectory("test");
        var watchService = FileSystems.getDefault()
                .newWatchService();
        var pathToWatch = Path.of("/tmp/test");
        pathToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        watchService.take()
                .pollEvents()
                .stream()
                .map(WatchEvent::context)
                .forEach(e -> {
                    System.out.println("File: " + e);
                });
    }
}
