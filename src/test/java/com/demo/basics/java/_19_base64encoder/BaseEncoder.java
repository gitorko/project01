package com.demo.basics.java._19_base64encoder;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseEncoder {

    @Test
    public void test() {
        String orig = "myname:password@123";
        //encoding  byte array into base 64
        byte[] encoded = Base64.encodeBase64(orig.getBytes());
        System.out.println("Original String: " + orig);
        System.out.println("Base64 Encoded String : " + new String(encoded));
        //decoding byte array into base64
        byte[] decoded = Base64.decodeBase64(encoded);
        System.out.println("Base 64 Decoded  String : " + new String(decoded));
        Assertions.assertEquals(new String(encoded), "bXluYW1lOnBhc3N3b3JkQDEyMw==" );
        Assertions.assertEquals(new String(decoded), "myname:password@123" );
    }

}
