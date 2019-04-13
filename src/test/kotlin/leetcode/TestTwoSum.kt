package leetcode

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestTwoSum : TestBase() {

    @Suppress("ArrayInDataClass")
    data class TwoSumParam(val num: IntArray, val target: Int, val expected: IntArray)

    lateinit var twoSum: TwoSum

    @BeforeEach
    fun beforeEach() {
        twoSum = TwoSum()
    }

    @Test
    fun doubleLoop() {
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.doubleLoop(num, target) `should equal` expected
        }
    }

    @Test
    fun indexOf() {
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.indexOf(num, target) `should equal` expected
        }
    }

    @Test
    fun parallelIndexOf() {
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.parallelIndexOf(num, target) `should equal` expected
        }
    }

    @Test
    fun hybrid() {
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.hybrid(num, target) `should equal` expected
        }
    }
}
