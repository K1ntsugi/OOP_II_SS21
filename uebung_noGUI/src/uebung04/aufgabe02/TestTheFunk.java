package uebung04.aufgabe02;

import java.util.function.IntBinaryOperator;

import uebung04.aufgabe03.YeahFunk_It;

public class TestTheFunk {

	public static void main(String[] args) {

		// Aufgabe 3
		Interfunk f = (int x) -> {
			return 2 * x;
		};

		System.out.println(f.machwas(5));
		System.out.println(f.machwas(10));

		f = (int x) -> {
			return 10 * x;
		};

		System.out.println(f.machwas(5));
		System.out.println(f.machwas(10));

		// Aufgabe 3
		YeahFunk_It g = () -> {
			return "Hallo";
		};

		System.out.println(g.machwas());

		// Aufgabe 4
		IntBinaryOperator op = (x, y) -> x + y;
		fancyAusgabe(op, 1, 2);

		op = (x, y) -> x * y;
		fancyAusgabe((x, y) -> x * y, 4, 5);

		fancyAusgabe((x, y) -> x % y, 10, 3);

	}

	public static void fancyAusgabe(IntBinaryOperator op, int x, int y) {
		System.out.println("***********");
		System.out.println("*" + x + "*" + y + "--->" + op.applyAsInt(x, y));
		System.out.println("***********");
	}

}
