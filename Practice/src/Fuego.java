
public class Fuego extends Pokemon implements IFuego {

	private int Etapa;

	

	protected Fuego(int num_pokedex, String nombrePokemon, double pesoPokemon, String sexo, int temporadaQueAparece,
			String tipo, int Etapa) {
		super(num_pokedex, nombrePokemon, pesoPokemon, sexo, temporadaQueAparece, tipo);
		this.Etapa = Etapa;
	}

	public void atacarPunioFuego() {
		System.out.println("Hola soy " + nombrePokemon + " estoy atacando con Puño de Fuego y estoy en Etapa " + Etapa);
		
	}

	@Override
	public void atacarAscuas() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Ascuas y estoy en Etapa " + Etapa);
		
	}

	@Override
	public void atacarLanzallamas() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Lanzallamas y estoy en Etapa " + Etapa);
		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Placaje y estoy en Etapa" + Etapa);
		
	}

	@Override
	protected void atacarAranazo() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Arañazo y estoy en Etapa" + Etapa);
		
	}

	@Override
	protected void atacarMordisco() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Mordisco y estoy en Etapa" + Etapa);
		
	}

	

}
