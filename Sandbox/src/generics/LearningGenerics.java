package generics;

public class LearningGenerics {

	public static void main(String[] args) {

		Object o1 = "String";
		String s1 = (String) o1;
		System.out.println(s1);
		// Funktioniert, weil das Objekt tatsächlich als String
		// gecastet werden kann bzw. auf den String "passt"

		Object o2 = Integer.valueOf(42);
		String s2 = (String) o2;
		System.out.println(s2);
		/*
		 * Die Wrapper-Klasse INTEGER verpackt die 42 als Objekt, dieses pass aber nicht
		 * in einen String. Der Compiler akzeptiert den Typecast, aber es knallt zur
		 * Laufzeit, weil die JVM nicht mehr eingreifen kann.
		 */

	}

}
