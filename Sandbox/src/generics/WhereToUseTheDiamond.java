package generics;

import java.util.ArrayList;
import java.util.List;

public class WhereToUseTheDiamond {
	// Nonsens-Beispiel: Soll nur Syntax demonstrieren
	public static ArrayList<String> foo(List<String> list) {
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list = new ArrayList<>();
		foo(new ArrayList<>(list));
	}

}
