package com.nowni.apps_list2.unscramble_Initial_Test.data

const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

val allWords: Set<String> =
    setOf(
        "at",
        "sea",
        "home",
        "arise",
        "banana",
        "android",
        "birthday",
        "briefcase",
        "motorcycle",
        "cauliflower"
    )

private val wordLengthMap: Map<Int, String> = allWords.associateBy({ it.length }, { it })

internal fun getUnscrambledWord(scrambledWord: String) = wordLengthMap[scrambledWord.length] ?: ""


