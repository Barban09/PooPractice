
public class Electrico extends Pokemon implements IElectrico {

	private int Etapa;
	private double Vida;	
	
	protected Electrico(int num_pokedex, String nombrePokemon, double pesoPokemon, String sexo, int temporadaQueAparece,
			String tipo, int Etapa, double Vida) {
		super(num_pokedex, nombrePokemon, pesoPokemon, sexo, temporadaQueAparece, tipo);
		
		this.Etapa = Etapa;
		this.Vida = Vida;
	}

	@Override
	public void atacarImpactrueno() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Impactrueno y tengo " + Vida + " puntos de vida");
		
	}

	@Override
	public void atacarPunioTrueno() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Puño Trueno");
		
	}

	@Override
	public void atacarRayo() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Rayo");
		
	}

	@Override
	public void atacarRayoCarga() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Rayo Carga");
		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy " + nombrePokemon + " Estoy atacando con Placaje");
		
	}

	@Override
	protected void atacarAranazo() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Arañazo");
		
	}

	@Override
	protected void atacarMordisco() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Mordisco");
		
	}



}
