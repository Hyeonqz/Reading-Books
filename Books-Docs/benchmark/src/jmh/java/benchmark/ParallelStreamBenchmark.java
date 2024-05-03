package benchmark;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2, jvmArgs = {"-Xms4G","-Xmx4G"})
public class ParallelStreamBenchmark {
	private static final long N = 10_000_000L;

/*	@Benchmark
	public long sequentialSum() {
		return Stream.iterate(1L, i-> i+1)
			.limit(N)
			.reduce(0L, Long::sum);
	}*/

	@Benchmark
	public long sequentialParallelSum() {
		return Stream.iterate(1L, i-> i+1)
			.limit(N)
			.parallel()
			.reduce(0L, Long::sum);
	}

/*	@Benchmark
	public long iterativeSum() {
		long result = 0;
		for (long i = 1L; i <N ; i++) {
			result += i;
		}
		return result;
	}*/

	@Benchmark
	public long parallelRangedSum() {
		return LongStream.rangeClosed(1,N)
			.parallel()
			.reduce(0L, Long::sum);
	}








































	@TearDown(Level.Invocation) // 벤치마크 실행 후 가비지 컬렉터 동작
	public void reset() {
		System.gc();
	}
}
