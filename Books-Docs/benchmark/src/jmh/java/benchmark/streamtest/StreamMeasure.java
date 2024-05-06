package benchmark.streamtest;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, jvmArgs = {"-Xms4G","-Xmx4G"})
public class StreamMeasure {
	private static final long N = 10_000_00_000L;

	public long iterativeSum() {
		return LongStream.rangeClosed(1L, N)
			.limit(N)
			.reduce(0L, Long::sum);
		}
	public long parallelRangedSum() {
		return LongStream.rangeClosed(1L,N)
			.parallel()
			.reduce(0L, Long::sum);
	}

	public static void main (String[] args) {
		StreamMeasure sm = new StreamMeasure();
		System.out.println(sm.iterativeSum());
		System.out.println(sm.parallelRangedSum());

	}

}
