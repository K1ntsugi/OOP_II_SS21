package uebung02;

public class MainPizza {

	public static void main(String[] args) {

		try {
			PizzaInYourFace[] FiBu = new PizzaInYourFace[2];

			FiBu[0] = new Margherita("gross");
			FiBu[1] = new Hawai();

			float sum = 0;

			for (PizzaInYourFace k : FiBu) {
				sum += k.getPreis();
			}

			System.out.println(sum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
