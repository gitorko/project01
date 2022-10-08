package com.demo.leetcode.easy._15_relativepath_71

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class RelativePathKt {

    @Test
    fun test() {
        Assertions.assertEquals("/a/c", simplifyPath("/a/b/.././c"))
        Assertions.assertEquals("/c", simplifyPath("/.././c"))
        Assertions.assertEquals("/", simplifyPath("/../"))
        Assertions.assertEquals("/a/bd/ef", simplifyPath("/./a/bd/ef/./gh/.."))
    }

    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        val tokens = path.split("/").toTypedArray()
        for (token in tokens) {
            if (token == "..") {
                if (!stack.isEmpty()) {
                    stack.pop()
                }
            } else if (token == ".") {
                //do nothing
            } else if (token == "") {
                //do nothing
            } else {
                stack.push(token)
            }
        }
        val sb = StringBuilder()
        for (s in stack) {
            sb.append("/")
            sb.append(s)
        }
        val result = sb.toString()
        return result.ifBlank { "/" }
        //return "/" + String.join("/", stack);
    }

}
