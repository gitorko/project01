package com.demo.basics.java._16_httpclient;

import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyStore;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class HttpClientOps {

    @Test
    public void test() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://jsonplaceholder.typicode.com/posts")).GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }

    @Test
    public void test_https() {
        try {
            HttpClient httpClient = CustomTrustStore.createHttpClientWithCustomTrustStore(
                    "/tmp/truststore.jks", "changeit"
            );
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }

    @Test
    @SneakyThrows
    public void test_async() {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        // Send the request asynchronously
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                // Process the response (thenApply transforms the result)
                .thenApply(HttpResponse::body)
                // Further action (thenAccept consumes the result)
                .thenAccept(responseBody -> {
                    System.out.println("Response received:");
                    System.out.println(responseBody);
                })
                .exceptionally(ex -> {
                    System.err.println("An error occurred: " + ex.getMessage());
                    return null;
                });

        // Keep the main thread alive to see the asynchronous response
        TimeUnit.SECONDS.sleep(5);
    }


    /**
     * echo | openssl s_client -connect jsonplaceholder.typicode.com:443 -showcerts > jsonplaceholder.crt
     * keytool -importcert -file jsonplaceholder.crt -keystore /tmp/truststore.jks -storepass changeit -alias jsonplaceholder
     * keytool -list -keystore /tmp/truststore.jks -storepass changeit
     *
     * java -Djavax.net.ssl.trustStore=truststore.jks -Djavax.net.ssl.trustStorePassword=changeit -jar YourApp.jar
     */
    class CustomTrustStore {
        public static HttpClient createHttpClientWithCustomTrustStore(String trustStorePath, String trustStorePassword) throws Exception {
            // Load the trust store
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try (FileInputStream fis = new FileInputStream(trustStorePath)) {
                keyStore.load(fis, trustStorePassword.toCharArray());
            }

            // Create a TrustManagerFactory with the loaded trust store
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            // Create an SSL context with the trust managers
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            // Create and return the HttpClient
            return HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();
        }
    }
}
