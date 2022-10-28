import java.util.Hashtable;
import java.util.stream.IntStream;

public class Engine {
	private Hashtable<Integer, Integer> hashtable;

	private Engine(Hashtable<Integer, Integer> hashtable) {

		this.hashtable = hashtable;
	}

	public static Engine create() {
		Hashtable<Integer,Integer> initialHashtable = new Hashtable<>();
		IntStream.range(1,17)
				.forEach((i -> initialHashtable.put(i, i)));
		return new Engine(initialHashtable);
	}

}
