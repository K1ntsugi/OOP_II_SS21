package aufgabe02;

import java.util.HashMap;
import java.util.Map;

public class aufgabe02_TestClass {

	public static void main(String[] args) {
		Student Harry = new Student(12345, "Harry");
		Student Ron = new Student(22222, "Ron");
		Student Hermine = new Student(33333, "Hermine");
		Student Dobby = new Student(12345, "Dobby");

		Map<Integer, Student> myHashMap = new HashMap<>();
		myHashMap.put(Harry.getInt_matrikelNR(), Harry);
		myHashMap.put(Ron.getInt_matrikelNR(), Ron);
		myHashMap.put(33333, Hermine);
		myHashMap.put(12345, Dobby);

		myHashMap.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue().getStr_name());
		});

		System.out.println(myHashMap.get(12345).getStr_name());
		System.out.println(myHashMap.containsValue(Ron) ? Ron.getStr_name() : false);

		// myHashMap.entrySet().iterator().next().getValue().getStr_name().equals("Ron");
		// System.out.println(myHashMap.entrySet().iterator().next().getValue().getStr_name().equals("Ron"));

		myHashMap.entrySet().forEach(e -> {
			if (e.getValue().getStr_name().equals("Ron")) {
				System.out.println("Ron");
			}
		});
	}
}