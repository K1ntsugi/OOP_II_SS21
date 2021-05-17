package generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PlayerRocketDemo_nongeneric {

	public static void main(String[] args) {

		// Lösung ohne generische Klasse
		Player michael = new Player();
		michael.name = "Omar Arnold";
		Rocket rocket = new Rocket();
		Long aBigNumber = 111111111111111111L;
		rocket.set(aBigNumber);
		michael.leftRocket = rocket;
		michael.rightRocket = new Rocket(2222222222222222222L);

		System.out.println(michael.name + " transportiert in der Rakete " + michael.leftRocket.get() + " und "
				+ michael.rightRocket.get());

		Long val1 = (Long) michael.leftRocket.get(); // 2
		Long val2 = (Long) michael.rightRocket.get();

		System.out.println(val1.compareTo(val2) > 0 ? "Links" : "Rechts");

		// Lösung mit generischer Klasse
		// Merke: Generics akzeptieren KEINE primitiven Datentypen
		Rocket_generic<Integer> intRocket = new Rocket_generic<Integer>();
		Rocket_generic<String> stringRocket = new Rocket_generic<String>();
		intRocket.set(1);
		int x = intRocket.get();
		stringRocket.set("BlaBla");
		String s = stringRocket.get();
		System.out.println(x + " " + s);

		/*
		 * Beispiel für geschachtelte Generics
		 */

		Rocket_generic<Rocket_generic<String>> rocketOfRockets = new Rocket_generic<Rocket_generic<String>>();
		rocketOfRockets.set(new Rocket_generic<String>());
		rocketOfRockets.get().set("Inner Rocket<String>");
		System.out.println(rocketOfRockets.get().get());

		/*
		 * Diamond-OPerator
		 */
		List<Map<Date, String>> listOfMaps;
		listOfMaps = new ArrayList<Map<Date, String>>(); // umständlich die Datentypen zweimal zu nennen
		/*
		 * Verfügt der Compiler über alle Typinformationen, so können die generischen
		 * Typargumente hinter "new" entfallen und durch den den Diamond-Operator <>
		 * erstzt werden.
		 */
		List<Map<Date, String>> listOfMaps_V2;
		listOfMaps_V2 = new ArrayList<>();
		// Das geht wegen einer Compiler-eigenschaft namens "Typ-Inferenz"

	}

}
