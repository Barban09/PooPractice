
public class Planta extends Pokemon implements IPlanta {

	private int Etapa;
	private double Vida;
	
	
	protected Planta(int num_pokedex, String nombrePokemon, double pesoPokemon, String sexo, int temporadaQueAparece,
			String tipo, int Etapa, double Vida) {
		super(num_pokedex, nombrePokemon, pesoPokemon, sexo, temporadaQueAparece, tipo);
		this.Etapa = Etapa;
		this.Vida = Vida;
	}

	@Override
	public void atacarParalizar() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Paralizar y tengo " + Vida + " puntos de vida" );
		
	}

	@Override
	public void atacarDrenaje() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Drenaje");
		
	}

	@Override
	public void atacarHojaAfilada() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Hoja Afilada");
		
	}

	@Override
	public void atacarLatigoCepa() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Latigo Cepa");
		
	}

	@Override
	protected void atacarPlacaje() {
		System.out.println("Hola soy " + nombrePokemon + "Estoy atacando con Placaje");
		
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
