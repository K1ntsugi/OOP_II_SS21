package uebung02;

public class Margherita implements PizzaInYourFace {

	private float preis = -1;
	private String[] zutaten = { "Tomaten", "Käse" };
	private String size;

	public Margherita(String size) throws Exception {

		this.size = size.toLowerCase();

		if (this.size != "klein" && this.size != "gross" && this.size != "mittel") {
			throw new Exception("Ungültige Eingabe");
		}

		if (this.size == "klein") {
			preis = 5F;
		}

		if (this.size == "mittel") {
			preis = 6.5F;
		}

		if (this.size == "gross") {
			preis = 8.7F;
		}

	}

	public String getSize() {
		return size;
	}

	@Override
	public float getPreis() {
		return preis;
	}

	@Override
	public String[] getZutaten() {
		return zutaten;
	}

}
