package benchmark.streamtest;

import java.util.Set;
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
public class PrimitiveMeasure {
	private static final long N = 10_000_00_000L;

/*	@Benchmark
	public long iterativeSum() {
		long result = 0;
		for (long i = 1L; i <= N ; i++) {
			result += i;
		}
		return result;
	}

	@Benchmark
	public long sequentialSum() {
		return Stream.iterate(1L, i-> i+1)
			.limit(N)
			.reduce(0L, Long::sum);
	}

	@Benchmark
	public long sequentialLongSum() {
		return LongStream.iterate(1L, i -> i+1)
			.limit(N)
			.reduce(0L, Long::sum);
	}*/

}
