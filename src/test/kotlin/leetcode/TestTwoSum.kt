package leetcode

import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.amshove.kluent.`should equal`
import org.amshove.kluent.shouldThrow
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
        // success
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.doubleLoop(num, target) `should equal` expected
        }

        // fail
        listOf(
            TwoSumParam(intArrayOf(1, 2), 4, intArrayOf(0, 1))
        ).forEach { (num, target, expected) ->
            { twoSum.doubleLoop(num, target) } shouldThrow IllegalArgumentException::class
        }
    }

    @Test
    fun indexOf() {
        // success
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.indexOf(num, target) `should equal` expected
        }

        // fail
        listOf(
            TwoSumParam(intArrayOf(1, 2), 4, intArrayOf(0, 1))
        ).forEach { (num, target, expected) ->
            { twoSum.doubleLoop(num, target) } shouldThrow IllegalArgumentException::class
        }
    }

    @Test
    fun parallelIndexOf() {
        // success
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1)),
            TwoSumParam(intArrayOf(0, 1, 2), 3, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(0, 1, 2), 2, intArrayOf(0, 2)),
            TwoSumParam(intArrayOf(0, -2, 4), 2, intArrayOf(1, 2)),
            TwoSumParam(intArrayOf(1, 2, 3, 4, 5), 8, intArrayOf(2, 4))
        ).forEach { (num, target, expected) ->
            twoSum.parallelIndexOf(num, target) `should equal` expected
        }

        // fail
        listOf(
            TwoSumParam(intArrayOf(1, 2), 4, intArrayOf(0, 1))
        ).forEach { (num, target, expected) ->
            { twoSum.doubleLoop(num, target) } shouldThrow IllegalArgumentException::class
        }
    }

    @Test
    fun hybrid() {
        // should call TwoSum#indexOf()
        var spiedWwoSum = spy(twoSum)
        listOf(
            TwoSumParam(intArrayOf(1, 2), 3, intArrayOf(0, 1))
        ).forEach { (num, target) ->
            spiedWwoSum.hybrid(num, target)
            verify(spiedWwoSum, times(1)).indexOf(num, target)
        }

        // should call TwoSum#parallelIndexOf()
        spiedWwoSum = spy(twoSum)
        listOf(
            TwoSumParam((0..TwoSum.THRESHOLD).toList().toIntArray(), 3, intArrayOf(0, 1))
        ).forEach { (num, target) ->
            spiedWwoSum.hybrid(num, target)
            verify(spiedWwoSum, times(1)).parallelIndexOf(num, target)
        }
    }
}
