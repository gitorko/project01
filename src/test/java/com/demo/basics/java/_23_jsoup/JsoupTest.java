package com.demo.basics.java._23_jsoup;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JsoupTest {

    @SneakyThrows
    @Test
    @Disabled
    public void test() {
        String blogUrl = "https://spring.io/blog";
        Document doc = Jsoup.connect(blogUrl).get();
        System.out.println(doc.title());
    }
}
