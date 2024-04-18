import java.util.Arrays;
import java.util.List;

public class Dish {
	private final String name;
	private final boolean vegetraian;
	private final int calories;
	private final Type type;

	public enum Type {
		MEAT, FISH, OTHER
	}

	public Dish (String name, boolean vegetraian, int calories, Type type) {
		this.name = name;
		this.vegetraian = vegetraian;
		this.calories = calories;
		this.type = type;
	}

	public String getName () {
		return name;
	}

	public boolean isvegetraian () {
		return vegetraian;
	}

	public int getCalories () {
		return calories;
	}

	public Type getType () {
		return type;
	}

	List<Dish> menu = Arrays.asList(
		new Dish("pork",false,800,Type.MEAT),
		new Dish("beef",false,1000,Type.MEAT),
		new Dish("french fries",true,450,Type.OTHER),
		new Dish("salmon",false,400,Type.FISH)
	);

}
