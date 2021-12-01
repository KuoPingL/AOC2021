package day1

import readInput
import java.lang.Exception

fun main() {
    fun part1(input: List<String>): Int {
        when (val size = input.size) {
            0 -> return -1
            1 -> {
                try {
                    return input.elementAt(0).toInt()
                } catch (e: Exception) {
                    return -1
                }
            }
            else -> {
                try {
                    var previous = input.first().toInt()
                    var current = 0
                    var increamented = 0
                    for (index in 1..input.size - 1) {
                        current = input.elementAt(index).toInt()
                        if (current > previous) increamented ++

                        previous = current
                    }
                    return increamented
                } catch (e: Exception) {
                    return -1
                }
            }
        }
    }

    fun part2(input: List<String>): Int {
        when (val size = input.size) {
            0 -> return -1
            in 1..3 -> {
                return -1
            }
            else -> {
                try {
                    var first = input.first().toInt()
                    var second = input.elementAt(1).toInt()
                    var third = input.elementAt(2).toInt()
                    var previous = first + second + third
                    var current = 0
                    var increamented = 0
                    for (index in 1..input.size - 3) {
                        first = input.elementAt(index).toInt()
                        second = input.elementAt(index + 1).toInt()
                        third = input.elementAt(index + 2).toInt()
                        current = first + second + third
                        if (current > previous) increamented ++

                        previous = current
                    }
                    return increamented
                } catch (e: Exception) {
                    return -1
                }
            }
        }
    }

    val input = readInput("Day01")
    check(part1(input) == 7)
    val testInput = readInput("Day01_test")
    println(part1(testInput))

    val day2TestInput = readInput("Day01_test")
    println(part2(day2TestInput))


}
