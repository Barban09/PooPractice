
public class Agua extends Pokemon implements IAgua {

	private int Etapa;
	
	protected Agua(int num_pokedex, String nombrePokemon, double pesoPokemon, String sexo, int temporadaQueAparece,
			String tipo, int Etapa) {
		super(num_pokedex, nombrePokemon, pesoPokemon, sexo, temporadaQueAparece, tipo);
		this.Etapa = Etapa;
	}

	@Override
	public void atacarHidrobomba() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Hidrobomba y estoy en Etapa " + Etapa);
		
	}

	@Override
	public void atacarPistolaAgua() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Pistola de Agua");
		
	}

	@Override
	public void atacarBurbuja() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Burbuja");
		
	}

	@Override
	public void atacarHidropulso() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Hidropulso");
		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Estoy atacando con Placaje");
		
	}

	@Override
	protected void atacarAranazo() {
		System.out.println("Estoy atacando con Arañazo");
		
	}

	@Override
	protected void atacarMordisco() {
		System.out.println("Estoy atacando con Mordisco");
		
	}

}
