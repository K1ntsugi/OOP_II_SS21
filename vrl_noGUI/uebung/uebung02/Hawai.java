package uebung02;

public class Hawai implements PizzaInYourFace {

	private float preis = 7.4F;
	private String[] zutaten = { "Tomaten", "Käse", "Annanas", "Schinken" };

	@Override
	public float getPreis() {
		return preis;
	}

	@Override
	public String[] getZutaten() {
		return zutaten;
	}

}
