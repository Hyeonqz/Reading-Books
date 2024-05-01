import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.TearDown;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xms4G"})
public class ParallelStreamBenchMark {
	private static final long N = 10_000_000L;

	@Benchmark
	public long sequentialSum() {
		return Stream.iterate(1L, i -> i+1)
			.limit(N)
			.reduce(0L, Long::sum);
	}

	@TearDown(Level.Invocation)
	public void reset() {
		System.gc(); // 벤치 마크 실행 후 가바지 컬렉터 동작 시키기
	}


}
