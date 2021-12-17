package day2_dive

import org.jetbrains.annotations.NotNull
import readInput
import java.io.File

fun main() {

    fun getDirection(input: String): Day02Direction {
        val match = Regex("(\\w+) (\\d+)").find(input)
        if (match != null){
            val (direction, value) = match.destructured
            return when(direction) {
                Day02Directions.FORWARD.str -> Day02Direction(Day02Directions.FORWARD, value.toLong())
                Day02Directions.DOWN.str -> Day02Direction(Day02Directions.DOWN, value.toLong())
                else -> Day02Direction(Day02Directions.UP, value.toLong())
            }
        }
        return Day02Direction(Day02Directions.None, 0)
    }

    fun part1(input: List<String>): Long {
        var horizontal = 0L
        var vertical = 0L
        for (line in input) {
            val direction = getDirection(line)
            when (direction.direction) {
                Day02Directions.FORWARD -> horizontal += direction.value
                Day02Directions.UP -> vertical -= direction.value
                else -> vertical += direction.value
            }
        }
        return horizontal * vertical
    }

    fun part2(input: List<String>): Long {
        var horizontal = 0L
        var vertical = 0L
        var aim = 0L
        for (line in input) {
            val direction = getDirection(line)
            when (direction.direction) {
                Day02Directions.FORWARD -> {
                    horizontal += direction.value
                    vertical += direction.value * aim
                }
                Day02Directions.UP -> {
                    aim -= direction.value
                }
                else -> {
                    aim += direction.value
                }
            }
        }
        return horizontal * vertical
    }

    val input = File("src/day2_dive", "Inputs.txt").readLines()
    print("PART 1 RESULT : ${part1(input)}")
    print("PART 1 RESULT : ${part2(input)}")

}

enum class Day02Directions(val str: String) {
    FORWARD("forward"), DOWN("down"), UP("up"), None("none")
}

data class Day02Direction(val direction: Day02Directions, val value: Long)