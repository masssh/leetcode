package leetcode

class TwoSum {
    fun doubleLoop(num: IntArray, target: Int): IntArray {
        for (i in 0 until num.size - 1) {
            for (j in 1 until num.size) {
                if (num[i] + num[j] == target) return intArrayOf(i, j)
            }
        }
        throw IllegalArgumentException("No combination of numbers found")
    }

    fun indexOf(num: IntArray, target: Int): IntArray {
        for (i in 0 until num.size) {
            val j = num.indexOf(target - num[i])
            if (j >= 0) return intArrayOf(i, j)
        }
        throw IllegalArgumentException("No combination of numbers found")
    }

    fun parallelIndexOf(num: IntArray, target: Int): IntArray {
        val pair = (0 until num.size).toList().parallelStream()
            .map { i -> i to num.indexOf(target - num[i]) }
            .filter { o -> o.second >= 0 }
            .findFirst()
            .orElseThrow { IllegalArgumentException("No combination of numbers found") }
        return intArrayOf(pair.first, pair.second)
    }

    fun hybrid(num: IntArray, target: Int): IntArray {
        val size = num.size
        if (size < 2000) {
            for (i in 0 until size) {
                val j = num.indexOf(target - num[i])
                if (j >= 0) return intArrayOf(i, j)
            }
            throw IllegalArgumentException("No combination of numbers found")
        } else {
            val pair = (0 until size).toList().parallelStream()
                .map { i -> i to num.indexOf(target - num[i]) }
                .filter { o -> o.second >= 0 }
                .findFirst()
                .orElseThrow { IllegalArgumentException("No combination of numbers found") }
            return intArrayOf(pair.first, pair.second)
        }
    }
}
