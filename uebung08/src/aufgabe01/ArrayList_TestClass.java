package aufgabe01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayList_TestClass {

	public static void main(String[] args) {

		ArrayList<String> shopping = new ArrayList<>();
		shopping.add("Milch");
		shopping.add("Ei");
		shopping.add("Schokolade");
		shopping.add("10 Tonnen Klopapier");
		System.out.println("Output 1:");
		showArrayList(shopping);
		shopping.remove(3);
		System.out.println("Output 2:");
		showArrayList(shopping);
		Collections.sort(shopping); // sortiert alphabetisch
		System.out.println();
		System.out.println("Output 3:");
		showArrayList(shopping);
		Collections.sort(shopping, Collections.reverseOrder());
		System.out.println();
		System.out.println("Output 4:");
		iterateList(shopping);
		System.out.println();
		shopping.remove("Ei");
		System.out.println("Output 5:");
		iterateList(shopping);
		shopping.sort(Collections.reverseOrder());
		System.out.println("\nMy Imperator:");
		shopping.add("Ziegel");
		shopping.add("Apfel");
		Collections.sort(shopping);
		reverseOrderComperator myComparator = new reverseOrderComperator();
		Collections.sort(shopping, myComparator);
		iterateList(shopping);
		// #trololol Comparator<String> reverse = Collections.reverseOrder();

	}

	public static void showArrayList(ArrayList<String> arrLst) {
		for (int i = 0; i < arrLst.size(); i++) {
			System.out.println(arrLst.get(i));
		}
	}

	public static void iterateList(ArrayList<String> arrLst) {
		for (Iterator<String> i = arrLst.iterator(); i.hasNext();) {
			System.out.println(i.next());
		}
	}

}
