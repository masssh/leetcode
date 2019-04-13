package masssh.leetcode

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class BenchmarkTwoSum {

    @Benchmark
    fun doubleLoop_10000() {
        val num = (-5000..5000).toList().toIntArray()
        val target = 61000
        val twoSum = TwoSum()
        twoSum.doubleLoop(num, target)
    }

    @Benchmark
    fun indexOf_10000() {
        val num = (-5000..5000).toList().toIntArray()
        val target = 6100
        val twoSum = TwoSum()
        twoSum.indexOf(num, target)
    }

    @Benchmark
    fun parallelIndexOf_10000() {
        val num = (-5000..5000).toList().toIntArray()
        val target = 6100
        val twoSum = TwoSum()
        twoSum.parallelIndexOf(num, target)
    }

    @Benchmark
    fun hybrid_10000() {
        val num = (-5000..5000).toList().toIntArray()
        val target = 6100
        val twoSum = TwoSum()
        twoSum.hybrid(num, target)
    }
}
