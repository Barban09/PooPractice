package ProgramacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	List<Ventas> Carros = Arrays.asList(
    			new Ventas("Volkswagen", "Amarok", 25000),
    			new Ventas("Volkswagen", "Taos", 32000),
    			new Ventas("Chevrolet", "Onix", 22000),
    			new Ventas("Chevrolet", "Tracker", 30000),
    			new Ventas("Fiat", "Cronos", 21000),
    			new Ventas("Fiat", "Pulse", 24000),
    			new Ventas("Toyota", "Corolla", 28000),
    			new Ventas("Toyota", "Yaris", 23000),
    			new Ventas("Renault", "Stepway", 20000),
    			new Ventas("Renault", "Duster", 27000)
    			);  
        //Ordering the list in ascending order
    	System.out.println("------------------------- Ordering the list in ascending order ------------------------------------");
    	List<Ventas> Price = Carros;
    	Price.sort(Comparator.comparing(Ventas::getPrecio));
    	Price.stream().forEach(System.out::println);
        
    	//Order by brand and price using sorted()
    	System.out.println("------------------------- Order by brand and price using sorted() ------------------------------------");
    	Carros.stream().sorted(Comparator.comparing(Ventas::getMarca).thenComparing(Ventas::getPrecio)).forEach(System.out::println);;
    	
    	//Cars with a price less than 23K
    	System.out.println("------------------------- Cars with a price less than 23K ------------------------------------");
    	Carros.stream().filter(car -> car.getPrecio() <= 23000).forEach(System.out::println);
    	
    	//Cars whose brand is Chevrolet or Renault
    	System.out.println("-------------------------- Cars whose brand is Chevrolet or Renault -----------------------------------");
    	Carros.stream().filter(car -> car.getMarca() == "Volkswagen" || car.getMarca()== "Renault").forEach(System.out::println);
    	
    	//Cars whose model contains an "a"
    	System.out.println("-------------------------- Cars whose model contains an \"a\"----------------------------------");
    	Carros.stream().filter(car -> car.getModelo().toLowerCase().contains("a")).forEach(System.out::println);
    	
    } 
}
