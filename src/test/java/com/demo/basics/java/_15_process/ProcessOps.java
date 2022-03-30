package com.demo.basics.java._15_process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ProcessOps {
    public static void main(String[] args) {

        try {
            System.out.println("ProcessBuilderExample.Start!!");
            final File batchFile = new File("src/main/resources/shell/demo.sh");
            ProcessBuilder processBuilder = new ProcessBuilder(batchFile.getAbsolutePath());

            Process process = processBuilder.start();

            int resposneCode = process.waitFor();
            if (resposneCode == 0) {
                System.out.println("Process executed successfully");
                InputStream inputStream = process.getInputStream();
                String result = readInputStreamData(inputStream);
                System.out.println(result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readInputStreamData(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines()
                    .collect(Collectors.joining("\n"));
        }
    }
}
