package generics;

public class Rocket_generic<T> {
	private T value;

	public Rocket_generic() {
	};

	public Rocket_generic(T value) {
		this.value = value;
	}

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public void empty() {
		value = null;
	}

}
