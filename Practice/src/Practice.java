
public class Practice {

	public static void main(String[] args) {
		Fuego Fuego1 = new Fuego(1,"Charmander",10.5,"M",1,"Fuego",1);
		Fuego1.atacarPunioFuego();
		Fuego1.atacarAscuas();
		
		Agua Agua1 = new Agua(2,"Bulbasur",15,"M",1,"Agua",1);
		Agua1.atacarAranazo();
		Agua1.atacarBurbuja();
		Agua1.atacarHidrobomba();

		Planta Planta1 = new Planta(3,"Chikorita", 12.5,"F",2, "Planta", 3, 500.75);
		Planta1.atacarAranazo();
		Planta1.atacarHojaAfilada();
		
		Electrico Electrico1 = new Electrico(4,"Pikachu", 7.5,"M", 2, "Planta", 1, 1000.5);
		Electrico1.atacarAranazo();
		Electrico1.atacarPunioTrueno();
		Electrico1.atacarImpactrueno();
	}

}
