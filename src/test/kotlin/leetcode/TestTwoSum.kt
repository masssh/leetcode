package leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestTwoSum {

    lateinit var twoSum: TwoSum;

    @BeforeEach
    fun beforeEach() {
        twoSum = TwoSum()
    }

    @Test
    fun shouldReturnIntArray() {
        val num = intArrayOf(1, 2, 3)
        val target = 5
        val actual = twoSum.twoSum(num, target)
        val expected = intArrayOf(1, 2)
        assertThat(actual).isEqualTo(expected)
    }

}
