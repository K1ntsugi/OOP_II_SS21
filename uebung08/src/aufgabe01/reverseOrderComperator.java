package aufgabe01;

import java.util.Comparator;

public class reverseOrderComperator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {

		return o2.compareTo(o1);

	}

}
