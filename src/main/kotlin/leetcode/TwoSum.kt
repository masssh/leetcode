package leetcode

open class TwoSum {
    open fun twoSum(num: IntArray, target: Int): IntArray {
        for (i in 0..(num.size - 1)) {
            for (j in 1..(num.size)) {
                if (num[i] + num[j] == target) return intArrayOf(i, j)
            }
        }
        throw IllegalArgumentException("No combination of numbers found")
    }
}
