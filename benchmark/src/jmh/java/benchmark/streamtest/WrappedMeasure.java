package benchmark.streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1, jvmArgs = {"-Xms4G","-Xmx4G"})
public class WrappedMeasure {
	private static final Long N = 10_000_00L;

	private static final int SIZE = 10_000_00;

	private ArrayList<Long> arrayList;

/*	@Setup
	public void setup() {
		// 벤치마크 실행 전 초기화 작업
		arrayList = new ArrayList<>(SIZE);
		for (long i = 1L; i <= SIZE; i++) {
			arrayList.add(i);
		}
	}

	@Benchmark
	public Long iterativeSum() {
		Long result = 0L;
		for (Long value : arrayList) {
			result += value;
		}
		return result;
	}

	@Benchmark
	public Long sequentialSum() {
		return arrayList.stream()
			.reduce(0L, Long::sum);
	}

	@Benchmark
	public Long sequentialLongSum() {
		return arrayList.stream()
			.mapToLong(Long::longValue)
			.reduce(0L, Long::sum);
	}*/

/*	@Benchmark
	public Long iterativeSum() {
		Long result = 0L;
		for (long i = 1L; i <= N ; i++) {
			result += i;
		}
		return result;
	}

	@Benchmark
	public Long sequentialSum() {
		return Stream.iterate(1L, i -> i + 1L)
			.limit(N)
			.reduce(0L, Long::sum);
	}

	@Benchmark
	public Long sequentialLongSum() {
		return LongStream.iterate(1L, i -> i+1L)
			.limit(N)
			.reduce(0L, Long::sum);
	}*/




}
