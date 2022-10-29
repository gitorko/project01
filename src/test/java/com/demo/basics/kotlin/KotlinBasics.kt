package com.demo.basics.kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class KotlinBasics {

    @Test
    fun test1() {
        val name = "Jack"
        println("Hi, $name!")
        println("Length, ${name.length}")
    }

    @Test
    fun test2() {
        var age = 40
        println("Age, $age")
        age = 50
        println("Age, $age")
    }

    @Test
    fun test3() {
        Assertions.assertEquals("Hello Jack", hello3("Jack"))
    }

    private fun hello3(name: String): String {
        return "Hello $name"
    }

    @Test
    fun test4() {
        val names = mutableListOf("Jack", "Ram")
        for (name in names) {
            println(name)
        }
        println()
        val countries = listOf("India", "France")
        for (country in countries) {
            println(country)
        }
        println()
        val currencies = arrayOf("Dollar", "Rupee")
        for (currency in currencies) {
            println(currency)
        }
    }

    @Test
    fun test5() {
        for (i in 0..5) {           // Loop over a range from 0 to 10
            println("value = $i")
        }
        println()
        for (i in 0 until 5) {           // Loop over a range from 0 to 10
            println("value = $i")
        }
        println()
        for (i in 0..5 step 2) {           // Loop over a range from 0 to 10
            println("value = $i")
        }
        println()
        for (i in 5 downTo 0) {
            println("value = $i")
        }
    }

    @Test
    fun test6() {
        greet6("Jack")
    }

    //void return type
    private fun greet6(name: String): Unit {
        println("Hello $name")
    }

    @Test
    fun test7() {
        greet7("Jack")
        greet7(country = "USA", name = "Jack")
    }

    //void return type
    private fun greet7(name: String, country: String = "India") {
        println("$name from $country")
    }

    @Test
    fun test8() {
        val countries = listOf("India", "France")
        //destructuring
        for ((index, country) in countries.withIndex()) {
            println("$index. $country")
        }
    }

    @Test
    fun test9() {
        val countries = listOf("India", "France")
        //destructuring
        for (i in countries.indices) {
            println(countries[i])
        }
        println()
        for (i in countries.indices) {
            println("$i. ${countries[i]}")
        }
    }

    @Test
    fun test10() {
        println(process10((1)))
        println(process10((15)))
        println(process10(("Hello")))
        println(process10((2.5)))
    }

    private fun process10(input: Any): String {
        return when (input) {
            1 -> "one"
            in 13..19 -> "teen"
            is String -> "its a string"
            else -> "nothing"
        }
    }

    @Test
    fun test11() {
        val name1 = null
        println(name1)

        val name2: String? = null
        println(name2)
    }

    @Test
    fun test12() {
        val name1 = "Jack"
        if (name1 == "Jack") {
            println("matches")
        } else {
            println("doesnt match")
        }
    }

    @Test
    fun test13() {
        //elvis operator
        println(greet13("Jack")?.length ?: 0)
        println(greet13("Adam")?.length ?: 0)
    }

    private fun greet13(name: String): String? {
        if (name == "Jack") {
            return "Hello Jack"
        }
        return null
    }

    @Test
    fun test14() {
        val nums = listOf(1, 2, 3)
        nums.forEach { println(it) }
        println()
        nums.forEach(::println)
    }

    @Test
    fun test15() {
        val isEven: (Int) -> Boolean = { num -> num % 2 == 0 }
        val isEven2 = { num: Int -> num % 2 == 0 }
        println(isEven(4))
        println(isEven2(6))
    }

    @Test
    fun test16() {
        fun double(x: Int) = x * 2;
        val doubleNum: (Int) -> Int = { num -> double(num) }
        println(doubleNum(5))
    }

    @Test
    fun test17() {
        //extensions
        val greet = "hello"
        fun String.shout() = uppercase(Locale.getDefault())
        println(greet.shout())
    }


    @Test
    fun test18() {
        class Car(var color: String, year: Int) {
            var manufactured = year
                get() = field
                set(value: Int) {
                    if (value < 2020) {
                        throw RuntimeException("ERROR!")
                    }
                    field = value
                }
        }

        val car = Car("Red", 2022)
        println(car.color)
        car.color = "Blue"
        println(car.color)
        println(car.manufactured)

        //car.manufactured = 2019
    }

    @Test
    fun test19() {
        data class Person(val name: String, val age: Int)

        val person = Person("Jack", 35)
        println(person)
    }

    @Test
    fun test20() {
        val executor = Executors.newSingleThreadExecutor()
        executor.execute { println(Date()) }
        println("Done!")
    }

    @Test
    fun test21() {
        class Job : Callable<String> {
            override fun call(): String {
                return "Hello world!"
            }
        }

        val executor = Executors.newSingleThreadExecutor()
        val submit = executor.submit(Job());
        println(submit.get())
        println("Done!")
    }

    @Test
    fun test22() {
        var table = Array(5) { IntArray(6) }
        for (i in 0 until 5) {
            for (j in 0 until 6) {
                table[i][j] = i + j
            }
        }
        for (i in 0 until 5) {
            for (j in 0 until 6) {
                print(table[i][j])
            }
            println()
        }
    }

}
