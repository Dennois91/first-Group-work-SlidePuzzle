package models;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InversionCounter {
	public Integer count(List<Integer> numbers) {
		AtomicInteger numberToCompareIndex = new AtomicInteger(0);
		AtomicInteger sublistStartIndex = new AtomicInteger(1);
		return numbers.stream()
				.map(number -> numbers.subList(sublistStartIndex.getAndIncrement(),numbers.size()))
				.map(sublist -> {
					var a = numbers.get(numberToCompareIndex.getAndIncrement());
					return sublist.stream()
							.filter(b -> a>b)
							.count();
				})
				.mapToInt(Long::intValue)
				.reduce(Integer::sum)
				.orElse(0);
	}
}
