package utils

import java.util.Scanner

object InputHelper {
    private val scanner = Scanner(System.`in`)

    fun readString(prompt: String): String {
        println(prompt)
        return scanner.nextLine().trim()
    }

    fun readNonEmptyString(prompt: String, errorMessage: String): String {
        while (true) {
            val input = readString(prompt)
            if (input.isNotEmpty()) {
                return input
            }
            println(errorMessage)
        }
    }
}