package leetcode

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class TestTwoSum : TestBase() {

    @Suppress("ArrayInDataClass")
    data class TwoSumParam(val num: IntArray, val target: Int, val expected: IntArray)

    @Test
    fun with2Params() {
        val twoSum = TwoSum()

        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1))
        ).forEach { (num, target, expected) ->
            twoSum.twoSum(num, target) `should equal` expected
        }
    }
}
