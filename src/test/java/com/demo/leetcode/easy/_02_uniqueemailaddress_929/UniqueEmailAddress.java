package com.demo.leetcode.easy._02_uniqueemailaddress_929;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [929. Unique Email Addresses - EASY](https://leetcode.com/problems/unique-email-addresses/)
 *
 * - set + split & replace ops
 *
 * https://www.youtube.com/watch?v=TC_xLIWl7qY&ab_channel=NeetCode
 */
public class UniqueEmailAddress {

    @Test
    public void test() {
        String emails[] = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        Assertions.assertEquals(2, numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> normalized = new HashSet<>();
        for (String email : emails) {
            // split into local and domain parts.
            String[] parts = email.split("@");
            // split local by '+'.
            String[] local = parts[0].split("\\+");
            // remove all '.', and concatenate '@' and domain.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return normalized.size();
    }
}
