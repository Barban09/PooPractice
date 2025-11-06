
public abstract class Pokemon{
	protected int num_pokedex;
	protected String nombrePokemon;
	protected double pesoPokemon;
	protected String sexo;
	protected int temporadaQueAparece;
	protected String tipo;
	
	
	
	
	protected Pokemon(int num_pokedex, String nombrePokemon, double pesoPokemon, String sexo, int temporadaQueAparece,
			String tipo) {
		this.num_pokedex = num_pokedex;
		this.nombrePokemon = nombrePokemon;
		this.pesoPokemon = pesoPokemon;
		this.sexo = sexo;
		this.temporadaQueAparece = temporadaQueAparece;
		this.tipo = tipo;
	}

	protected abstract void atacarPlacaje();
	
	protected abstract void atacarAranazo();
	
	protected abstract void atacarMordisco();
	
	
}
