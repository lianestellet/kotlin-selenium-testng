package utils

import java.util.*
import kotlin.streams.asSequence

object Generate {

    fun name(): String {
        return lowerCaseString(6)
    }

    fun username(): String {
        return lowerCaseString(7) + numberString(4)
    }

    fun password(): String {
        return lowerCaseString(4) +
               upperCaseString(4) +
               numberString(2) +
               specialCharacters(1)
    }


    public fun randomNumberBetween(from: Int, to: Int): Int {
        val random = Random()
        return random.nextInt(from..to)
    }

    private fun Random.nextInt(range: IntRange): Int {
        return range.start + nextInt(range.last - range.start)
    }

    private fun lowerCaseString(size: Long): String {
        val source = "abcdefghijklmnopqrstuvyxwz"
        return getRandomCharacters(source, size)
    }

    private fun upperCaseString(size: Long): String {
        val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        return getRandomCharacters(source, size)
    }

    private fun numberString(size: Long): String {
        val source = "1234567890"
        return getRandomCharacters(source, size)
    }

    private fun specialCharacters(size: Long): String {
        val source = "!@#$%&"
        return getRandomCharacters(source, size)
    }

    private fun getRandomCharacters(source: String, size: Long): String {
        return Random().ints(size, 0, source.length)
                .asSequence()
                .map(source::get)
                .joinToString("")
    }


}